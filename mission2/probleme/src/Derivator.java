import java.io.IOException;

/**
 *  Syntax : java Derivator infile outfile
 */
public class Derivator {

	public static void main(String[] args) {
		FileRW io = new FileRW(args[0], args[1]);
		
		// Define supported operation list
		Operator[] operationsList = {new Addition(), new Subtraction(), new Multiplication(),
				new Division(), new Power(), new Sinus(), new Cosinus()};
		
		// For each line (expression)
        try {
        	String line;
			while((line = io.getReader().readLine()) != null)
			{
				// Create tree, derive it, and print resulting tree in output file
				FormalExpressionTree inTree = new FormalExpressionBTree(line, operationsList);
				FormalExpressionTree outTree = inTree; //inTree.derive();
				io.getWriter().println(outTree.toString());
			}
		} catch (IOException e) {
			System.err.println("Error while reading file");
			e.printStackTrace();
		}
        
        io.close();
	}

}
