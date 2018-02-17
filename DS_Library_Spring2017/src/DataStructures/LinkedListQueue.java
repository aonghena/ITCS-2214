/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;




/**
 * Implements the queue interface as a linked list. 
 * @author clatulip
 * @version 2017-09-29
 * @param <T> a generic element
 */
public class LinkedListQueue<T> implements QueueADT<T> {
    private LinearNode<T> front;
    private LinearNode<T> back;
    private int numNodes;

    /**
     * Default constructor for LinkedListQueue.
     */
    public LinkedListQueue() {
        numNodes = 0;
        front = null;
        back = null;
    }
    
    
    @Override
    public void enqueue(T element) {
        LinearNode<T> temp = new LinearNode<>(element);
        if (back == null) {
            // queue is empty, adding first node
            back = temp;
            front = temp;
            numNodes++;
            return;
        }
        temp.setPrev(back);
        back.setNext(temp);
        back = temp;
        numNodes++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (numNodes == 0) {
            throw new EmptyCollectionException("Linked List Queue");
        }
        T element = front.getElement();
        front = front.getNext();
        numNodes--;
        return element;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (numNodes == 0) {
            throw new EmptyCollectionException("Linked List Queue");
        }
        T element = front.getElement();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }

    @Override
    public int size() {
        return numNodes;
    }

    @Override
    public String toString() {
        String q = "";
        LinearNode current = front;
        int num = numNodes;
        while (num > 0) {
            q = q.concat(", " + current.getElement().toString());
            current = current.getNext();
            num--;
        }
        return q;
    }
    
    
}
