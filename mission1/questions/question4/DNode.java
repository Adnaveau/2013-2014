
/**
 * Décrivez votre classe DNode ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DNode<E>
{
    // Instance variables: 
    private E element; 
    private DNode<E> next; 
    private DNode<E> previous;
   
    /* Creates a node with null references to its element and next node. */ 
    public DNode() {
       this(null, null, null);
    }
    
    /* Creates a node with the given element and next node. */
    public DNode(E e, DNode<E> n, DNode<E> p) {
        element = e;
        next = n;
        previous = p;
    }
    
    // Accessor methods:
    public E getElement() {
        return element;
    }
    
    public DNode<E> getNext()
    {
        return next;
    }
    
    public DNode<E> getPrevious()
    {
        return previous;
    }
    
    // Modifier methods:
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
