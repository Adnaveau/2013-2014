package probleme;

public class Exchange implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		Double first = (Double) stack.pop();
		Double second = (Double) stack.pop();
		stack.push(first);
		stack.push(second);
	}

}
