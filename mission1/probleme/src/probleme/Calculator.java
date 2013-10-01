package probleme;

import java.util.EmptyStackException;
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
	
    public static void main(String[] args)
    {
    	
    	// Data structures used for the program
    	// symbols contains links to classes of operations to be done
    	// definitions contains the definitions created by the user
    	// stack contains the numbers stack
		Map<String, Operation> symbols = new HashMap<String, Operation>();
        Map<String, Double> definitions = new HashMap<String, Double>();
        NodeStack<Object> stack = new NodeStack<Object>();
        FileRW io = new FileRW(args[0], args[1]);
        
        // Adding some operations
        symbols.put("pstack", new StackPrinter(io));
        symbols.put("add", new Addition());
        symbols.put("sub", new Substraction());
        symbols.put("mul", new Multiplication());
        symbols.put("div", new Division());
        symbols.put("dup", new Duplication());
        symbols.put("exch", new Exchange());
        symbols.put("eq", new Equal());
        symbols.put("ne", new NotEqual());
        symbols.put("pop", new StackPop());
        symbols.put("def", new Definition(definitions));
        
        // Reading tokens
        String fileContent = io.readFile();
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
        		stack.push(token.substring(1));
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
        			if(! symbols.containsKey(token))
        			{
        				System.err.println("Unknown command : " + token);
        				System.exit(1);
        			}
        			
        			try
        			{
        				Operation todo = symbols.get(token);
        				todo.eval(stack);
        			}
        			catch(EmptyStackException e)
        			{
        				System.err.println("Stack error near command : " + token);
        				System.exit(1);
        			}
        		}
        	}
        }
        strTok.close();
        io.close();
    }
}

