package patientheapsimulation;


/**
 * A simplified interface for a maxHeap
 * 
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 */
public interface HeapADT<T> extends CollectionADT {
    
    /**
     * Returns the element at the root, without removing it
     * @return the element at the root
     * @throws EmptyCollectionException 
     */
    public T findMax() throws EmptyCollectionException;
    
    /**
     * Removes and returns the element at the root
     * @return the element at the root
     * @throws EmptyCollectionException 
     */
    public T removeMax() throws EmptyCollectionException;
    
    /**
     * 
     * Adds the element to the heap, and adjusts the heap to maintain validity
     * @param element the element to be added
     */
    public void addElement(T targetElement) ;
    
    
}
