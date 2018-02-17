
package DataStructures;

/**
 * A linked Stack implementation
 * @author clatulip
 */
public class LinkedStack<T> implements StackADT<T> {
    private int count;
    private LinearNode<T> top;

    public LinkedStack() {
        count = 0;
        top = null;
        
    }
    
    @Override
    public T pop() throws EmptyCollectionException {
        T result;
        if (count != 0) {
            result = top.getElement();
            top = top.getNext();
            count--;
        } else {
            throw new EmptyCollectionException("Linked List Stack");
        }
        return result;
        
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return "LinkedListStack{" + "count=" + count + ", top=" + top + '}';
    }

    @Override
    public void push(T element) {
        LinearNode temp = new LinearNode(element);
        if(count == 0){
            top = temp;
            count++;
        }else{
            temp.setNext(top);
            top = temp;
            count++;
        }
    }

    @Override
    public T peek() throws EmptyCollectionException {
        T result;
        if (count != 0) {
            result = top.getElement();
        } else {
            throw new EmptyCollectionException("Linked List Stack");
        }
        return result;
    }
    
    
}
