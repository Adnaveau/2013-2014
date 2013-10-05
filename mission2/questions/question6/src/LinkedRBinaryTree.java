import java.util.ArrayList;


public class LinkedRBinaryTree<E> implements RBinaryTree<E> {

	private Position<E> value;
	private RBinaryTree<E> left, right;
	
	public LinkedRBinaryTree(E value, RBinaryTree<E> left, RBinaryTree<E> right)
	{
		this.value = new Node<E>(value);
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean isEmpty() {
		return root() == null && leftTree() == null && rightTree() == null;
	}

	@Override
	public int size() {
		return ((ArrayList<Position<E>>) positions()).size();
	}

	@Override
	public Position<E> root() {
		return value;
	}

	@Override
	public boolean isLeaf() {
		return leftTree() == null & rightTree() == null;
	}

	@Override
	public RBinaryTree<E> leftTree() {
		return left;
	}

	@Override
	public RBinaryTree<E> rightTree() {
		return right;
	}

	@Override
	public void setElement(E o) {
		value = new Node<E>(o);
	}

	@Override
	public void setLeft(RBinaryTree<E> tree) {
		left = tree;

	}

	@Override
	public void setRight(RBinaryTree<E> tree) {
		right = tree;

	}

	@Override
	public Iterable<Position<E>> positions() {
		ArrayList<Position<E>> positions = new ArrayList<Position<E>>();
		inorderPositions(this, positions);
		return positions;
	}
	
	private void inorderPositions(RBinaryTree<E> v, ArrayList<Position<E>> pos)
	{
		if(v.leftTree() != null)
			inorderPositions(v.leftTree(), pos);
		if(v.root() != null)
			pos.add(v.root());
		if(v.rightTree() != null)
			inorderPositions(v.rightTree(), pos);
	}

}
