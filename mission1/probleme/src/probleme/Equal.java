package probleme;

public class Equal implements Operation {

	@Override
	public void eval(NodeStack<Double> stack) {
		// TODO Stub de la méthode généré automatiquement
		Double first = stack.pop();
		Double second = stack.pop();
		Boolean third = first.equals(second);
		FileRW.writeFile(Calculator.OUTFILE, third.toString());
	}

}
