package probleme;

public class NotEqual implements Operation {
	
	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		Object first = stack.pop();
		Object second = stack.pop();
		Boolean third = first.equals(second);
		stack.push(! third);
	}
}
