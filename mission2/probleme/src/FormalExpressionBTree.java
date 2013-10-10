
public class FormalExpressionBTree implements FormalExpressionTree {

	private Node root;
	private FormalExpressionTree left;
	private FormalExpressionTree right;
	
	public FormalExpressionBTree(String expr)
	{
		
	}
	
	public FormalExpressionBTree(Node root, FormalExpressionTree left, FormalExpressionTree right)
	{
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public FormalExpressionTree derive() {
		return this.root.derive(left, right);
	}

	@Override
	public void setLeft(FormalExpressionTree left) {
		this.left = left;
	}

	@Override
	public void setRight(FormalExpressionTree right) {
		this.right = right;

	}

	@Override
	public FormalExpressionTree getLeft() {
		return left;
	}

	@Override
	public FormalExpressionTree getRight() {
		return right;
	}

	@Override
	public Node getRoot() {
		return root;
	}

	@Override
	public void setRoot(Node n) {
		this.root = n;

	}
	
	@Override
	public String toString() {
		String result = "(";
		if(left != null)
			result += left.toString();
		result += root.toString();
		if(right != null)
			result += right.toString();
		result += ")";
		return result;
	}

}
