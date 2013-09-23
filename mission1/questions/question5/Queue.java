public interface Queue<E> {
    
    /**
    * Returns the number of elements in the queue.
    * @return number of elements in the queue.
    * @pre -
    * @post size() >= 0
    */
    public int size();
    
    /**
    * Returns whether the queue is empty.
    * @return true if the queue is empty, false otherwise.
    * @pre -
    * @post isEmpty() = true or false
    */
    public boolean isEmpty();
    
    /**
    * Inspects the element at the front of the queue.
    * @return element at the front of the queue.
    * @exception EmptyQueueException if the queue is empty.
    * @pre - (exception thrown if the queue is empty)
    * @post front() = the front element
    */
    public E front() throws EmptyQueueException;
    
    /**
    * Inserts an element at the rear of the queue.
    * @param element new element to be inserted.
    * @pre element != null
    * @post element E is enqueued
    */
    public void enqueue (E element);
    
    /**
    * Removes the element at the front of the queue.
    * @return element removed.
    * @exception EmptyQueueException if the queue is empty.
    * @pre - (exception thrown if queue is empty)
    * @post dequeue() = the front element, and element is dequeued
    */
    public E dequeue() throws EmptyQueueException;
}