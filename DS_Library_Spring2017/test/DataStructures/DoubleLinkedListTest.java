/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clatulip
 */
public class DoubleLinkedListTest {

    /**
     * Test of addFirst method, of class DoubleLinkedList.
     */
    @Test
    public void testAddFirst() {

        System.out.println("addFirst");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        assertTrue(list.isEmpty());
        list.addFirst(7);
        assertEquals(list.size(), 1);
        assertFalse(list.isEmpty());
        try {
            assertEquals(list.first(), (Integer) 7);
            assertEquals(list.last(), (Integer) 7);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        assertEquals(list.size(), 2);
        try {
            assertEquals(list.first(),(Integer)3);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    /**
     * Test of addLast method, of class DoubleLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        assertTrue(list.isEmpty());
        list.addLast(7);
        assertEquals(list.size(), 1);
        assertFalse(list.isEmpty());
        try {
            assertEquals(list.first(), (Integer) 7);
            assertEquals(list.last(), (Integer) 7);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addLast(3);
        assertEquals(list.size(), 2);
        try {
            assertEquals(list.last(),(Integer)3);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of addAfter method, of class DoubleLinkedList.
     */
    @Test
    public void testAddAfter() throws Exception {
        System.out.println("addAfter");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.addFirst(7);

        try {
            list.addAfter(7,18);
            assertEquals(list.size(), 2);
            assertFalse(list.isEmpty());
            assertEquals(list.first(), (Integer)7);
            assertEquals(list.last(), (Integer)18);
        } catch (EmptyCollectionException | ElementNotFoundException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        
        try {
            list.addAfter(22,4);
            assertEquals(list.first(),(Integer)45);
            assertEquals(list.size(),6);
            assertEquals(list.last(), (Integer)18);
            Integer result = list.remove(4);
            assertEquals(result, (Integer)4);
        } catch (EmptyCollectionException | ElementNotFoundException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of remove method, of class DoubleLinkedList.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.remove(7), (Integer)7);
            assertEquals(list.size(), 0);
            assertTrue(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.remove(22),(Integer)22);
            assertEquals(list.size(),2);
            assertEquals(list.first(), (Integer)45);
            assertEquals(list.last(), (Integer)3);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of removeFirst method, of class DoubleLinkedList.
     */
    @Test
    public void testRemoveFirst() throws Exception {
        System.out.println("removeFirst");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.removeFirst(), (Integer)7);
            assertEquals(list.size(), 0);
            assertTrue(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.removeFirst(),(Integer)45);
            assertEquals(list.size(),2);
            assertEquals(list.first(), (Integer)22);
            assertEquals(list.last(), (Integer)3);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of removeLast method, of class DoubleLinkedList.
     */
    @Test
    public void testRemoveLast() throws Exception {
        System.out.println("removeLast");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.removeLast(), (Integer)7);
            assertEquals(list.size(), 0);
            assertTrue(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.removeLast(),(Integer)3);
            assertEquals(list.size(),2);
            assertEquals(list.first(), (Integer)45);
            assertEquals(list.last(), (Integer)22);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of first method, of class DoubleLinkedList.
     */
    @Test
    public void testFirst() throws Exception {
        System.out.println("first");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.first(), (Integer)7);
            assertEquals(list.size(), 1);
            assertFalse(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.first(),(Integer)45);
            assertEquals(list.size(),4);

        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of last method, of class DoubleLinkedList.
     */
    @Test
    public void testLast() throws Exception {
        System.out.println("last");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        try {
            assertEquals(list.last(), (Integer)7);
            assertEquals(list.size(), 1);
            assertFalse(list.isEmpty());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        try {
            assertEquals(list.last(),(Integer)7);
            assertEquals(list.size(),4);

        } catch (EmptyCollectionException ex) {
            Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of isEmpty method, of class DoubleLinkedList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
        list.addFirst(7);
        assertFalse(list.isEmpty());
        list.addFirst(3);
        list.addFirst(22);
        list.addFirst(45);
        assertFalse(list.isEmpty());
        while (list.size() != 0) {
            try {
                Integer i = list.removeFirst();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        assertTrue(list.isEmpty());
    }

    /**
     * Test of size method, of class DoubleLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(list.size(), 0);
        list.addFirst(7);
        assertEquals(list.size(), 1);
        list.addFirst(3);
        assertEquals(list.size(), 2);
        list.addFirst(22);
        assertEquals(list.size(), 3);
        list.addFirst(45);
        assertEquals(list.size(), 4);
        while (!list.isEmpty()) {
            try {
                Integer i = list.removeFirst();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(DoubleLinkedListTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        assertEquals(list.size(), 0);
    }

}
