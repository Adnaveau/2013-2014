package probleme;

public class Multiplication implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		Double first = (Double) stack.pop();
		Double second = (Double) stack.pop();
		Double third = first * second;
		stack.push(third);
	}

}
