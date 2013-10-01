package probleme;

public class Substraction implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		Object first = (Double) stack.pop();
		Object second = (Double) stack.pop();
		if(! first.getClass().equals(second.getClass())) 
		{
			System.err.println("Error : Operation on different data types");
			System.exit(1);
		} 
		Double third = (Double) first - (Double) second;
		stack.push(third);
	}

}
