/*

 */
package DataStructures;

import java.util.ArrayList;

/**
 *
 * @author Alex Onghena
 * @version 1.1 
 * 
 * @param <T> element
 */
public class WorkAheadQueue<T extends Comparable>
        implements WorkAheadQueueADT<T> {

    private LinearNode<T> front;
    private LinearNode<T> back;
    private int numNodes;
    private ArrayList<LinearNode<T>> frontFive;

    /**
     * default constructor
     */
    public WorkAheadQueue() {
        front = null;
        back = null;
        numNodes = 0;
        frontFive = new ArrayList<LinearNode<T>>(5);
    }

    /**
     * enqueue add element to back of queue
     * @param element - element to be added to LinearNode
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> temp = new LinearNode<>(element);
        if (back == null) {
            // queue is empty, adding first node
            back = temp;
            front = temp;
            numNodes++;
            frontFive.add(temp);
            return;
        }
        back.setNext(temp);
        back = temp;
        numNodes++;
        //adds to the frontFive arraylist it has less than 6 elements 
        if (frontFive.size() < 6) {
            frontFive.add(temp);
        }

    }

    /**
     * Removes and returns the first element
     * Precondition: x must be less than 5, x must be less than size
     * @return the element removed from the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        //check precondition
        if (numNodes == 0) {
            throw new EmptyCollectionException("Linked List Queue");
        }
        //get element
        T element = front.getElement();
        front = front.getNext();
        frontFive.remove(0);
        // if numNodes is greater than 5 then add next element to arraylist
        if (numNodes > 5) {
            frontFive.add(frontFive.get(4).getNext());
        }
        numNodes--;
        return element;
    }
    
    /**
     * Returns (without removing) the first element in the queue.
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (numNodes == 0) {
            throw new EmptyCollectionException("Linked List Queue");
        }
        T element = front.getElement();
        return element;
    }

    /**
     * Removes and returns the element that is at place x in the queue.
     * Precondition: x must be less than 5, x must be less than size
     * Note: indexing from 0: 0 == front element, 1 == second element, etc.
     * @param x the passed in index of the element to be removed
     * @return the element removed from the queue
     * @throws EmptyCollectionException if the queue is empty
     * @throws InvalidArgumentException if x > 4, or x > size of collection
     */
    @Override
    public T dequeue(int x) throws EmptyCollectionException,
            InvalidArgumentException {
        //check precondition 
        if (isEmpty()) {
            throw new EmptyCollectionException("Linked List Queue");
        }
        if (x > 4 || x >= size()) {
            throw new InvalidArgumentException("Linked List Queue");
        }
        //get element at x
        T element = frontFive.get(x).getElement();
        //check x
        //if at the rear of the arraylist
        if (x == 4) {
            back = frontFive.get(x - 1);
            back.setNext(null);
            frontFive.remove(x);
            if (numNodes > 5) {
                frontFive.add(frontFive.get(4).getNext());
            }
        } 
        //if not at end or front
        else if (x != 0) {
            //set prvious to x nexta
            frontFive.get(x - 1).setNext(frontFive.get(x).getNext());
            //remove element
            frontFive.remove(x);
            //add if there is an element after the 4th in the arraylist
            if (numNodes > 5) {
                frontFive.add(frontFive.get(4).getNext());
            }
        }
        //if not at front
        else if (x == 0) {
            //call and return  dequeue 
            return dequeue();
        }
        numNodes--;
        return element;
    }

    /**
     * Returns (without removing) the element that is at place x in the queue.
     * Precondition: x must be less than 5, x must be less than size Note:
     * indexing from 0: 0 == front element, 1 == second element, etc.
     * @return the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     * @throws InvalidArgumentException if x > 4, or x > size of collection
     * @param x the specified index of the element to return
     */
    @Override
    public T first(int x) throws EmptyCollectionException,
            InvalidArgumentException {
        //check precondition of throw exception 
        if (isEmpty()) {
            throw new EmptyCollectionException("Linked List Queue");
        }
        if (x > 4 || x > size()) {
            throw new InvalidArgumentException("Linked List Queue");
        }
        T element = frontFive.get(x).getElement();
        return element;
    }

    /**
     * Returns an ArrayList of the first five nodes in the queue.
     * @return ArrayList<LinearNode<T>>[] array of nodes
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public ArrayList<LinearNode<T>> firstFive() throws
            EmptyCollectionException {
        //if empty
        if (isEmpty()) {
            throw new EmptyCollectionException("Linked List Queue");
        }
        return frontFive;
    }
    /**
     * Return if queue is empty or not
     * @return if numNodes is 0 - true, or not - false 
     */
    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }
    /**
     * Returns the size of queue
     * @return numNodes
     */
    @Override
    public int size() {
        return numNodes;
    }

    /**
     * toString rep of the numNodes
     * @return string rep of queue 
     */
    @Override
    public String toString() {
        String q = "";
        LinearNode current = front;
        int num = numNodes;
        //create string to return 
        while (num > 0) {
            if (num == numNodes) {
                q = q.concat("" + current.getElement().toString());
            } 
            else {
                current = current.getNext();
                q = q.concat(", " + current.getElement().toString());
            }
            num--;
        }
        return q;
    }

}
