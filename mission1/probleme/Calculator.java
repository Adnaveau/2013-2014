/**
 * Décrivez votre classe Calculator ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Calculator
{
    
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public static void main(String[] args)
    {
//         Map<String, Class> m = new HashMap<String, Class>();
//         m.put("test", NodeStack.class);
//         try{
//         NodeStack test = (NodeStack) (m.get("test")).newInstance();
//         
//         } catch (InstantiationException x) {
//         }
//         catch (IllegalAccessException x) {
// 	    x.printStackTrace();
// 	   }
        NodeStack<Float> stack = new NodeStack<Float>();
        String fileContent = FileRW.readFile(args[0]);
        StringTokenizer strTok = new StringTokenizer(fileContent, " ");
        while(strTok.hasMoreElements())
        {
            String token = strTok.nextToken();
            float numberToken = 0;
            boolean isNumber;
            try
            {
                numberToken = Float.valueOf(token);
                isNumber = true;
            }
            catch(NumberFormatException e)
            {
                isNumber = false;
            }
            
            if(isNumber) stack.push(new Float(numberToken));
            else
            {
                
            }
        }
    }
}
