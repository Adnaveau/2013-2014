package probleme;

public class Duplication implements Operation{

	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		stack.push(stack.top());
	}

}
