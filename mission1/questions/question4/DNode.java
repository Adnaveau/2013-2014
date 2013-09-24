public class DNode<E>
{
    // Instance variables
    private E element; 
    private DNode<E> next; 
    private DNode<E> previous;
   
    //Creates a node with null references to its element and next node. 
    public DNode() {
       this(null, null, null);
    }
    
    // Creates a node with the given element and next node. 
    public DNode(E e, DNode<E> n, DNode<E> p) {
        element = e;
        next = n;
        previous = p;
    }
    
    // Returns the element
    public E getElement() {
        return element;
    }
    
    // Returns the next element
    public DNode<E> getNext()
    {
        return next;
    }
    
    // Returns the previous element
    public DNode<E> getPrevious()
    {
        return previous;
    }
    
    // Modifier methods
    public void setElement(E newElem) {
        element = newElem;
    }
    
    public void setNext(DNode<E> newNext) {
        next = newNext;
    }
    
    public void setPrevious(DNode<E> newPrevious) {
        previous = newPrevious;
    }
}
