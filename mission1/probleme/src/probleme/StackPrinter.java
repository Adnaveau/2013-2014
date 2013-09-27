package probleme;

public class StackPrinter implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		
		StringBuilder sb = new StringBuilder();
		
		Node<Object> current = stack.top;
        while(current != null)
        {
           sb.append(current.getElement().toString() + "\n");
           current = current.getNext(); 
        }
		
        FileRW.writeFile(Calculator.OUTFILE, sb.toString());
	}

}
