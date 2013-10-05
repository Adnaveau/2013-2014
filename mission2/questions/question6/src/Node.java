public class Node<E>  implements Position<E>
{
	private E value;

	public Node(E value)
	{
		this.value = value;
	}
	
	@Override
	public E element() {
		return value;
	}

}
