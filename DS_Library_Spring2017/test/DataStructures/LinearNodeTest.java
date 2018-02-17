/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clatulip
 */
public class LinearNodeTest {
    


    /**
     * Test of getNext method, of class LinearNode.
     */
    @Test
    public void testGetNext() {
        System.out.println("getNext");
        LinearNode<Integer> instance = new LinearNode<>(7);
        assertEquals(instance.getNext(),null);
        
        LinearNode<Integer> instance2 = new LinearNode<>(20);
        instance.setNext(instance2);
        assertEquals(instance.getNext(), instance2);
        assertEquals(instance2.getNext(), null);
        
    }

    /**
     * Test of setNext method, of class LinearNode.
     */
    @Test
    public void testSetNext() {
        System.out.println("setNext");
        LinearNode<Integer> instance = new LinearNode<>(7); 
        assertEquals(instance.getNext(), null);
        LinearNode<Integer> instance2 = new LinearNode<>(20);
        instance.setNext(instance2);
        assertEquals(instance.getNext(), instance2);
        instance.setNext(null);
        assertEquals(instance.getNext(), null);
    }

    /**
     * Test of getElement method, of class LinearNode.
     */
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        LinearNode<Integer> instance = new LinearNode<>(7); 
        assertEquals(instance.getElement(), (Integer)7);
        instance.setElement(3);
        assertEquals(instance.getElement(), (Integer)3);
        //instance = null;
        //assertEquals(instance.getNext(), null);
    }

    /**
     * Test of setElement method, of class LinearNode.
     */
    @Test
    public void testSetElement() {
        System.out.println("setElement");
        LinearNode<Integer> instance = new LinearNode<>(7); 
        assertEquals(instance.getElement(), (Integer)7);
        instance.setElement(3);
        assertEquals(instance.getElement(), (Integer)3);
    }

    /**
     * Test of getPrev method, of class LinearNode.
     */
    @Test
    public void testGetPrev() {
        System.out.println("getPrev");
        LinearNode<Integer> instance = new LinearNode<>(7);
        assertEquals(instance.getPrev(),null);
        
        LinearNode<Integer> instance2 = new LinearNode<>(20);
        instance.setPrev(instance2);
        assertEquals(instance.getPrev(), instance2);
        assertEquals(instance2.getPrev(), null);
        
    }

    /**
     * Test of setPrev method, of class LinearNode.
     */
    @Test
    public void testSetPrev() {
        System.out.println("setPrev");
        LinearNode<Integer> instance = new LinearNode<>(7);
        LinearNode<Integer> instance2 = new LinearNode<>(20);
        instance.setPrev(instance2);
        assertEquals(instance.getPrev(), instance2);
        assertEquals(instance2.getPrev(), null);
    }

    
    
}
