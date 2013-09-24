public class DNodeStack<E> implements Stack<E>
{
    protected DNode<E> top; // reference to the head node 
    protected DNode<E> bottom; // reference to the end node
    protected int size; // number of elements in the stack

    public DNodeStack()
    { // constructs an empty stack
        top = null;
        bottom = null;
        size =0 ;
    }
    
    public int size() { return size; }
    
    public boolean isEmpty()
    {
        if (top == null) return true;
        return false;
    }
    
    public void push(E elem) 
    {
        // create and, link-in a new node
        // as the top node has no previous node, null is passed as third argument
        DNode<E> v = new DNode<E>(elem, top, null);
        // if the list isn't empty, the new element becomes the previous element of
        // the current top element, else it becomes the bottom element moreover.
        if(top != null) top.setPrevious(v);
        else bottom = v;
        top = v;
        size++;
    }
    
    public E top() throws EmptyStackException
    { 
        if (isEmpty()) 
            throw new EmptyStackException("!!Stack is empty. !!");
        return top.getElement();
    }
    
    public E pop() throws EmptyStackException 
    {
        if(isEmpty())
            throw new EmptyStackException("!!Stack is empty. !!");
        E temp = top.getElement();
        top = top.getNext();
        size--;
        if(size==0) bottom = null;
        return temp;
    }
    
    public String toString()
    {
        DNode<E> current = top;
        String result = "Contents : ";
        while(current != null)
        {
           result +=  current.getElement().toString() + ((current.getNext() != null) ? "-->" : "");
           current = current.getNext(); 
        }
        return result;
    }
    
}
