package probleme;

import java.util.Map;

public class Definition implements Operation {

	private Map<String, Double> definitions;
	
	public Definition(Map<String, Double> definitions)
	{
		this.definitions = definitions;
	}
	
	@Override
	public void eval(NodeStack<Object> stack) {
		Double value = (Double) stack.pop();
		String key = (String) stack.pop();
		definitions.put(key, value);
	}

}
