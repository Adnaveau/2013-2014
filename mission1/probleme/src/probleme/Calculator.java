package probleme;

import java.util.Locale;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/*
 * Current syntax : java Calculator infile outfile
 * No defensive programming at this time
 */
public class Calculator
{
	public static String OUTFILE;
	
    public static void main(String[] args)
    {
    	OUTFILE = args[1];
    	
    	// Data structures used for the program
    	// symbols contains links to classes of operations to be done
    	// definitions contains the definitions created by the user
    	// stack contains the numbers stack
        @SuppressWarnings("rawtypes")
		Map<String, Class> symbols = new HashMap<String, Class>();
        Map<String, Double> definitions = new HashMap<String, Double>();
        NodeStack<Object> stack = new NodeStack<Object>();
        
        // Adding some operations
        symbols.put("pstack", StackPrinter.class);
        symbols.put("add", Addition.class);
        symbols.put("sub", Substraction.class);
        symbols.put("mul", Multiplication.class);
        symbols.put("div", Division.class);
        symbols.put("dup", Duplication.class);
        symbols.put("exch", Exchange.class);
        symbols.put("eq", Equal.class);
        symbols.put("ne", NotEqual.class);
        symbols.put("pop", StackPop.class);
        
        // Reading tokens
        String fileContent = FileRW.readFile(args[0]);
        Scanner strTok = new Scanner(fileContent);
        strTok.useLocale(Locale.US); // Enables "dot style" floating point numbers to be recognized as Double 
        while(strTok.hasNext())
        {
        	if(strTok.hasNextDouble()) // We have a number
        	{
        		Double token = strTok.nextDouble();
        		stack.push(token);
        		System.out.println("Double read : " + token);
        	}
        	else if(strTok.hasNext("\\s*/\\S+")) // We have a definition (regex for (space) + / + non-space characters)
        	{
        		String token = strTok.next();
        		Double value = 0.0;
    
        		if(strTok.hasNextDouble()) value = strTok.nextDouble();
        		else System.exit(1);
        		
        		if(! strTok.hasNext() || ! strTok.next().equals("def")) System.exit(1);
        		
        		definitions.put(token.substring(1), value);
        		System.out.println("Def read : " + token);
        	}
        	else // We have a symbol
        	{
        		String token = strTok.next();
        		
        		if(definitions.containsKey(token))
        		{
        			System.out.println("Double read : " + token);
        			stack.push(definitions.get(token));
        		}
        		else
        		{
        			System.out.println("Symbol read : " + token);
        			try 
        			{
        				Operation todo = (Operation) (symbols.get(token)).newInstance();
        				todo.eval(stack);
        			}
        			catch (InstantiationException x) {
        			}
        			catch (IllegalAccessException x) {
        			}	
        		}
    
        		
        	}
        }
        strTok.close();
    }
}

