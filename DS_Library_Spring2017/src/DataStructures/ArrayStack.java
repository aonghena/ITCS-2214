/*
 * ArrayStack Implementation
 * Author: @clatulip   2016
 */
package DataStructures;

import java.util.Arrays;

/**
 * ArrayStack Implementation
 * UNC Charlotte, 2016
 * @author clatulip
 * 
 */
public class ArrayStack<T> implements StackADT<T> {

    private T[] stack;
    private int top;
    private static int initCapacity = 50;

    public ArrayStack() {
        this(initCapacity);
    }

    public ArrayStack(int capacity) {
        stack = (T[])(new Object[capacity]);
        top = 0;
    }
    
    /**
     * Adds the specified element to the top of the stack
     * @param element element to be pushed onto the stack
     */
    @Override
    public void push(T element) {
        if (top == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    /**
     * Removes and returns the element that is on top of the stack
     * @return the element removed from the stack
     * @throws EmptyCollectionException 
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        T result = stack[top-1];
        top--;
        stack[top] = null;
        return result;
    }

    /**
     * Returns (without removing) the element that is on top of the stack
     * @return the element on top of the stack
     * @throws EmptyCollectionException 
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return stack[top - 1];
    }

    /**
     * Returns true if the stack contains no elements
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        if (top == 0)
            return true;
        return false;
    }

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack as an int
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * Returns a string representation of elements in the stack
     * @return a string representation of elements in the stack
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i<top; i++) {
            if (stack[i] != null) {
                sb.append(stack[i].toString());
                sb.append(", ");
            }
        }
        return "ArrayStack{" + sb + '}';
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length*2);
    }
    
    
     
}
