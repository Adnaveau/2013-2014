package probleme;

import java.util.Map;

public class Definition implements Operation {

	private Map<String, Object> definitions;
	private Map<String, Operation> symbols;
	
	public Definition(Map<String, Object> definitions, Map<String, Operation> symbols)
	{
		this.definitions = definitions;
		this.symbols = symbols;
	}
	
	@Override
	public void eval(NodeStack<Object> stack) {
		Object value =  stack.pop();
		String key = (String) stack.pop();
		if(symbols.containsKey(key))
		{
			System.err.println("Definition "+ key +" in conflict with operation");
			System.exit(1);
		}
		if(definitions.containsKey(key)) System.err.println("Warning :  double definition of " + key);
		definitions.put(key, value);
	}

}
