
public class Scalar implements Node {

	private Number value;
	
	public Scalar(Number value)
	{
		this.value = value;
	}
	
	@Override
	public FormalExpressionTree derive(FormalExpressionTree left,
			FormalExpressionTree right) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
