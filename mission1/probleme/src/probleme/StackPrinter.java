package probleme;

public class StackPrinter implements Operation {

	private String outfile;
	
	public StackPrinter(String outfile)
	{
		this.outfile = outfile;
	}
	
	@Override
	public void eval(NodeStack<Object> stack) {
		
		StringBuilder sb = new StringBuilder();
		
		Node<Object> current = stack.top;
        while(current != null)
        {
           sb.append(current.getElement().toString() + "\n");
           current = current.getNext(); 
        }
		
        FileRW.writeFile(outfile, sb.toString());
	}

}
