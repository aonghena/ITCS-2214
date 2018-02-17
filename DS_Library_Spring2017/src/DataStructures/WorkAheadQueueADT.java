package DataStructures;

import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * An interface for the workAheadQueue.
 * Specific workAheadQueue implementations will implement this interface
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2017
 * @author clatulip
 * @version 2017-09-29
 * @param <T> a generic parameter
 */
public interface WorkAheadQueueADT<T> extends QueueADT<T> {
    
    /**
     * Removes and returns the element that is at place x in the queue.
     * Precondition: x must be less than 5, x must be less than size
     * Note: indexing from 0: 0 == front element, 1 == second element, etc.
     * @param x the passed in index of the element to be removed
     * @return the element removed from the queue
     * @throws EmptyCollectionException if the queue is empty
     * @throws InvalidArgumentException if x > 4, or x > size of collection
     * 
     */
    public T dequeue(int x) throws EmptyCollectionException, 
            InvalidArgumentException;
    
    /**
     * Returns (without removing) the element that is at place x in the queue.
     * Precondition: x must be less than 5, x must be less than size
     * Note: indexing from 0: 0 == front element, 1 == second element, etc.
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     * @throws InvalidArgumentException if x > 4, or x > size of collection
     * @param x the specified index of the element to return
     */
    public T first(int x)throws EmptyCollectionException, 
            InvalidArgumentException;
    
    /**
     * Returns an ArrayList of the first five nodes in the queue.
     * @return ArrayList<LinearNode<T>>[] array of nodes
     * @throws EmptyCollectionException if the queue is empty
     */
    public ArrayList<LinearNode<T>> firstFive() throws EmptyCollectionException;
}
