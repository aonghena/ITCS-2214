/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class LinkedBinarySearchTreeTest {
    
    public LinkedBinarySearchTreeTest() {
    }

    /**
     * Test of addElement method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        Integer element = 2;
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        instance.addElement(element);
        assertEquals(instance.size(), 1);
        assertTrue(instance.contains(element));
        
        element = 2;
        instance = new LinkedBinarySearchTree();
        instance.addElement(element);
        instance.addElement(9);
        assertEquals(instance.size(), 2);
        assertTrue(instance.contains(9));
        
        
    }

    /**
     * Test of removeElement method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testRemoveElement() throws Exception {
        System.out.println("removeElement");
        Integer element = 2;
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        instance.addElement(element);
        assertEquals(instance.size(), 1);
        assertTrue(instance.contains(element));
        
        try{
            instance.removeElement(9);
            assertTrue(false);
        }catch(Exception e){
            assertTrue(true);
        }
        
        instance.removeElement(element);
        assertEquals(instance.size(), 0);
        assertFalse(instance.contains(element));
        
        element = 2;
        instance = new LinkedBinarySearchTree();
        instance.addElement(element);
        instance.addElement(9);
        assertEquals(instance.size(), 2);
        assertTrue(instance.contains(9));
        
        assertEquals(instance.removeElement(2), 2);
        assertEquals(instance.size(), 1);
        
        
    }

    /**
     * Test of removeAllOccurrences method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testRemoveAllOccurrences() throws Exception {
        System.out.println("removeAllOccurrences");
        Integer element = 2;
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        instance.addElement(element);
        instance.addElement(element);
        assertEquals(instance.size(), 2);
        assertTrue(instance.contains(element));
        
        instance.removeAllOccurrences(element);
        assertEquals(instance.size(), 0);
        assertFalse(instance.contains(element));
        
        element = 2;
        instance = new LinkedBinarySearchTree();
        instance.addElement(element);
        instance.addElement(9);
        assertEquals(instance.size(), 2);
        assertTrue(instance.contains(9));
        
        instance.removeElement(2);
        assertEquals(instance.size(), 1);
        assertFalse(instance.contains(2));
    }

    /**
     * Test of removeMin method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testRemoveMin() throws Exception {
        System.out.println("removeMin");
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        Object expResult = null;
        Object result = instance.removeMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMin method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testFindMin() throws Exception {
        System.out.println("findMin");
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        Object expResult = null;
        Object result = instance.findMin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMax method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testRemoveMax() {
        System.out.println("removeMax");
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        Object expResult = null;
        Object result = instance.removeMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTreeAsList method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testGetTreeAsList() {
        System.out.println("getTreeAsList");
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        ArrayList expResult = null;
        ArrayList result = instance.getTreeAsList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMax method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testFindMax() {
        System.out.println("findMax");
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        Object expResult = null;
        Object result = instance.findMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LinkedBinarySearchTree instance = new LinkedBinarySearchTree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
