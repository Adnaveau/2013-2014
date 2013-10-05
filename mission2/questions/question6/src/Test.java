public class Test {

	public static void main(String[] args) {
		RBinaryTree<Integer> t = new LinkedRBinaryTree<Integer>(50, null, null);
		t.setLeft(new LinkedRBinaryTree<Integer>(12, null, null));
		t.setRight(new LinkedRBinaryTree<Integer>(60, new LinkedRBinaryTree<Integer>(55, null, null), new LinkedRBinaryTree<Integer>(70, null, null)));
		System.out.println("Taille : " + t.size());
		Iterable<Position<Integer>> a = t.positions();
		for(Position<Integer> p : a)
		{
			System.out.println("Element :" + p.element());
		}
	}

}
