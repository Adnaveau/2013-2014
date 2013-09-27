package probleme;

public class Exchange implements Operation {

	@Override
	public void eval(NodeStack<Double> stack) {
		// TODO Stub de la méthode généré automatiquement
		Double first = stack.pop();
		Double second =  stack.pop();
		stack.push(first);
		stack.push(second);
	}

}
