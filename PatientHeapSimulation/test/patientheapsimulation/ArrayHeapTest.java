/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientheapsimulation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex Onghena
 * @version 1.1
 */
public class ArrayHeapTest {
    

    /**
     * Test of findMax method, of class ArrayHeap.
     */
    @Test
    public void testFindMax() throws Exception {
        System.out.println("findMax");
        
        ArrayHeap ph = new ArrayHeap();
        //test when nothing is inside
        try {
            assertEquals(ph.findMax(), null);
            assertEquals(ph.size(), -1);
        }
        catch (Exception e) {
            assertEquals(ph.size(), 0);
        }
        
        ph.addElement(1);
        ph.addElement(2);
        ph.addElement(3);
        assertEquals(ph.findMax(), 3);
        
        ArrayHeap instance = new ArrayHeap();
        instance.addElement("A");
        instance.addElement("zo");
        instance.addElement("b");
        assertEquals(instance.findMax(), "zo");
    }

    /**
     * Test of removeMax method, of class ArrayHeap.
     */
    @Test
    public void testRemoveMax() throws Exception {
        System.out.println("removeMax");
        //test int
        ArrayHeap ph = new ArrayHeap();  
        
        //test removeMax with nothing
        try {
            ph.removeMax();
            assertEquals(ph.size(), -1);
        }
        catch (Exception e) {
            assertEquals(ph.size(), 0);
        }
        
        ph.addElement(3);
        ph.removeMax();
        ph.addElement(2);
        assertEquals(ph.findMax(), 2);
        
        
        //test string
        ArrayHeap instance = new ArrayHeap();
        instance.addElement("A");
        instance.addElement("zo");
        instance.addElement("x");
        instance.addElement("yellow");
        instance.addElement("car");
        instance.addElement("pop");
        instance.addElement("op");
        instance.addElement("bitcoin");
        instance.addElement("btc");
        instance.addElement("amount");
        instance.addElement("billow");
        instance.addElement("yy");
        instance.removeMax();
        instance.removeMax();
        instance.removeMax();
        assertEquals(instance.findMax(), "x");
    }
    /**
     * Test of addElement method, of class ArrayHeap.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        //test int
        ArrayHeap ph = new ArrayHeap();
        assertEquals(ph.size(), 0);
        ph.addElement(1);
        assertEquals(ph.size(), 1);
        
        //adds a bunch of ints to make sure heapaddify works 
        for (int x = 0; x < 20; x++) { 
            ph.addElement(x);
        }
        assertEquals(ph.size(), 21);
        
        //test string
        ArrayHeap instance = new ArrayHeap();
        assertEquals(instance.size(), 0);
        instance.addElement("A");
        assertEquals(instance.size(), 1);
    }

    /**
     * Test of isEmpty method, of class ArrayHeap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayHeap instance = new ArrayHeap();
        assertEquals(instance.size(), 0);
        assertTrue(instance.isEmpty());
        instance.addElement("A");
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of size method, of class ArrayHeap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        
        //test with strings
        ArrayHeap instance = new ArrayHeap();
        assertEquals(instance.size(), 0);
        assertTrue(instance.isEmpty());
        instance.addElement("A");
        assertEquals(instance.size(), 1);
        
        //test with ints
        ArrayHeap ph = new ArrayHeap();
        assertEquals(ph.size(), 0);
        assertTrue(ph.isEmpty());
        ph.addElement(1);
        assertEquals(ph.size(), 1);
    }    
    
     /**
     * Test of toString method, of class Patient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ArrayHeap instance = new ArrayHeap();  
        instance.addElement("A");
        assertTrue(instance.toString().contains("A"));
        instance.addElement("zo");
        assertTrue(instance.toString().contains("zo"));
        

    }  
}
