public interface Operator extends Node{
	public boolean isUnaryOperator();
	public FormalExpressionTree clean(FormalExpressionTree left, FormalExpressionTree right);
}
