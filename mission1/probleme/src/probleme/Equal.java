package probleme;

public class Equal implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		Double first = (Double) stack.pop();
		Double second = (Double) stack.pop();
		Boolean third = first.equals(second);
		stack.push(third);
	}

}
