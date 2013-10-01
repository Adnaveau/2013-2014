package probleme;

public class Exchange implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		Object first = stack.pop();
		Object second = stack.pop();
		stack.push(first);
		stack.push(second);
	}

}
