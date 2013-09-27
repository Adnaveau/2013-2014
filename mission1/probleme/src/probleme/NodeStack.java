package probleme;

import java.util.EmptyStackException;

public class NodeStack<E> //implements Stack<E> 
{ 
        protected Node<E> top;
        protected int size;
        
        public NodeStack() 
        { // constructs an empty stack
            top = null;
            size = 0;
        }
        
        public int size() { 
            return size; 
        }
        
        public boolean isEmpty() {
                if (top == null) return true;
                return false;
        }
            
        public void push(E elem) {
                 Node<E> v = new Node<E>(elem, top); // create and, link-in a new node
                 top = v;
                 size++;
        }
                
        public E top() throws EmptyStackException { 
            if (isEmpty()) throw new EmptyStackException(); 
            return top.getElement();
        }
        
        public E pop() throws EmptyStackException { 
            if (isEmpty()) throw new EmptyStackException(); 
            E temp = top.getElement(); 
            top = top.getNext(); // link-out the former top node 
            size--; 
            return temp;
        } 
}