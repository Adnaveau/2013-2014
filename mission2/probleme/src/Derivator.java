import java.io.IOException;

public class Derivator {

	public static void main(String[] args) {
		FileRW io = new FileRW(args[0], args[1]);
		
		// For each line (expression)
        try {
        	String line;
			while((line = io.getReader().readLine()) != null)
			{
				// Create tree, derivate it, and 
				FormalExpressionTree inTree = new FormalExpressionBTree(line);
				FormalExpressionTree outTree = inTree.derive();
				io.getWriter().println(outTree.toString());
			}
		} catch (IOException e) {
			System.err.println("Error while reading file");
			e.printStackTrace();
		}
	}

}
