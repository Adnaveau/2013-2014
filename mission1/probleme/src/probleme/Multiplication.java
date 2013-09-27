package probleme;

public class Multiplication implements Operation {

	@Override
	public void eval(NodeStack<Double> stack) {
		// TODO Stub de la méthode généré automatiquement
		Double first = stack.pop();
		Double second = stack.pop();
		Double third = first * second;
		stack.push(third);
	}

}
