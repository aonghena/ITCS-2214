package DataStructures;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * An interface for a Queue.
 * Specific queue implementations will implement this interface
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2017
 * @author clatulip
 * @version 2017-09-29
 * @param <T> a generic element
 */
public interface QueueADT<T> extends CollectionADT<T> {
    
    /**
     * Adds the specified element to the end of the queue.
     * @param element element to be added to the end of the queue
     */
    public void enqueue(T element);
    
    /**
     * Removes and returns the element that is at the front of the queue.
     * @return the element removed from the queue
     * @throws EmptyCollectionException 
     */
    public T dequeue() throws EmptyCollectionException;
    
    /**
     * Returns (without removing) the element that is at the front of the queue.
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    public T first()throws EmptyCollectionException;
    
}
