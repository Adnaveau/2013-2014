package probleme;

public class StackPrinter implements Operation {

	private FileRW outfile;
	
	public StackPrinter(FileRW io)
	{
		this.outfile = io;
	}
	
	@Override
	public void eval(NodeStack<Object> stack) {
		Node<Object> current = stack.top;
        while(current != null)
        {
        	outfile.writeToFile(current.getElement().toString());
           current = current.getNext(); 
        }
	}

}
