package probleme;

public class StackPrinter implements Operation {

	@Override
	public void eval(NodeStack<Double> stack) {
		// TODO Stub de la méthode généré automatiquement
		Node<Double> current = stack.top;
        while(current != null)
        {
           System.out.println(current.getElement().toString());
           current = current.getNext(); 
        }
		
	}

}
