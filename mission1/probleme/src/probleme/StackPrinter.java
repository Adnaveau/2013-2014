package probleme;

public class StackPrinter implements Operation {

	@Override
	public void eval(NodeStack<Double> stack) {
		
		StringBuilder sb = new StringBuilder();
		
		Node<Double> current = stack.top;
        while(current != null)
        {
           sb.append(current.getElement().toString() + "\n");
           current = current.getNext(); 
        }
		
        FileRW.writeFile(Calculator.OUTFILE, sb.toString());
	}

}
