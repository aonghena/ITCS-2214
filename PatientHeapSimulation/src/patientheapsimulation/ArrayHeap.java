/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientheapsimulation;

import java.util.Arrays;

/**
 * An array-based maxHeap implementation.
 *
 * @author clatulip
 * @version 2017-10-17
 * @param <T>
 */
public class ArrayHeap<T extends Comparable> implements HeapADT<T> {

    private int count; // count points to next empty slot, also is size
    private T[] heap;
    private final int initCapacity = 10;

    /**
     * Constructor for class ArrayHeap.
     */
    public ArrayHeap() {
        heap = (T[]) (new Comparable[initCapacity]);
        count = 0;
    }

    /**
     * returns (without removing) the maximum element in the heap
     *
     * @return T the maximum element
     * @throws EmptyCollectionException
     */
    @Override
    public T findMax() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("Heap");
        }
        return heap[0];
    }

    /**
     * Removes and returns the maximum element in the heap The heap then changes
     * in order to maintain validity.
     *
     * @return T the maximum element
     * @throws EmptyCollectionException
     */
    @Override
    public T removeMax() throws EmptyCollectionException {
        if (count == 0) {
            throw new EmptyCollectionException("Heap");
        }
        if (count == 1) {
            return heap[--count];
        }

        T element = heap[0];
        heap[0] = heap[--count];
        heapifyRemove();
        return element;
    }

    /**
     * Adds the element to the heap, making sure that the heap remains valid
     *
     * @param element to be added
     */
    @Override
    public void addElement(T element) {
        if (count == heap.length) {
            expandCapacity();
        }
        heap[count++] = element;
        heapifyAdd(); // call this to ensure that the item swaps up, as needed

    }

    /**
     * Returns true if heap is empty, false otherwise
     *
     * @return boolean true if empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in the heap
     *
     * @return int the count of elements in the heap
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * private method that swaps out the new root, and swaps it down the heap
     * until it is in the correct position
     */
    private void heapifyRemove() {
        // called after the item at the bottom-left has been put at the root
        // we need to see if this items should swap down
        int k = 0;
        int left = 1;
        while (left < count) {
            int max = left;
            int right = left + 1;

            if (right < count && heap[right].compareTo(heap[left]) > 0) {
                max = right;
            }
            T parent = heap[k];
            T child = heap[max];

            if (parent.compareTo(child) < 0) {
                //swap

                heap[k] = child;
                heap[max] = parent;

                k = max;
                left = 2 * k + 1;
            } 
            else {
                break;
            }
        }

    }

    /**
     * Private utility method to expand Array capacity.
     */
    private void expandCapacity() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    /**
     * Private method to do swapping up the heap as needed, to put the newly
     * added element into the right position in the heap.
     */
    private void heapifyAdd() {
        int x = size() - 1;
        T element ;
        //compares parent to child
        while (x != 0 && (heap[x]).compareTo(heap[(x - 1) / 2]) > 0) {
            element = heap[x];
            heap[x] = heap[(x - 1) / 2];
            heap[(x - 1) / 2] = element;
            x = (x - 1) / 2;
        }
    }

    /**
     * toString method
     * @return string
     */
    @Override
    public String toString() {
        String arr = "";
        for (int i = 0; i < count; i++) {
            arr = arr.concat(heap[i].toString() + ", ");

        }
        return "ArrayHeap{" + "count=" + count + ", heap=" + arr + '}';
    }

}
