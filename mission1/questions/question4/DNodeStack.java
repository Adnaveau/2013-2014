/**
 * Décrivez votre classe DNodeStack ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DNodeStack<E> implements Stack<E>
{
    protected DNode<E> top; // reference to the head node 
    protected DNode<E> bottom;
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
        DNode<E> v = new DNode<E>(elem, top, null); // create and, link-in a new node
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
        top = top.getNext(); // link-out the former top node slze--; return temp;
        size--;
        return temp;
    }
    
    public String toString()
    {
        DNode<E> current = top;
        String result = "Contents : ";
        while(current != null)
        {
           //String prev = (current.getPrevious() != null) ? current.getPrevious().toString() : "null";
           //String next = (current.getNext() != null) ? current.getNext().toString() :"null";
           result +=  current.getElement().toString() + ((current.getNext() != null) ? "-->" : "");
           current = current.getNext(); 
        }
        return result;
    }
    
}
