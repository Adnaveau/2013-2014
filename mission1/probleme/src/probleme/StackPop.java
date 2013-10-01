package probleme;

public class StackPop implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		stack.pop();
	}

}
