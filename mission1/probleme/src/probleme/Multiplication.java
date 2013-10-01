package probleme;

public class Multiplication implements Operation {

	@Override
	public void eval(NodeStack<Object> stack) {
		// TODO Stub de la méthode généré automatiquement
		Object first =  stack.pop();
		Object second =  stack.pop();
		if(! first.getClass().equals(second.getClass())) 
		{
			System.err.println("Error : Operation on different data types");
			System.exit(1);
		}
		Double third = (Double) first * (Double) second;
		stack.push(third);
	}

}
