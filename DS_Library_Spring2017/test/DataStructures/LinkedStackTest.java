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
 * @author Alex
 */
public class LinkedStackTest {
    
    public LinkedStackTest() {
    }

    /**
     * Test of pop method, of class LinkedStack.
     * 
     */
    @Test
    public void testPop() throws Exception {
        System.out.println("pop");
        //new String instance
        LinkedStack<String> instance = new LinkedStack<>();
        assertEquals(instance.isEmpty(), true);
        LinearNode expResult = new LinearNode("jo");
        instance.push("oa");
        instance.push("jo");
        instance.push("Hello");//push
        instance.pop();
        LinearNode result = new LinearNode(instance.pop());//get pop
        assertEquals((expResult.toString()),result.toString());
        
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedStack instance = new LinkedStack();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedStack instance = new LinkedStack();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class LinkedStack.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LinkedStack instance = new LinkedStack();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() throws Exception{
        System.out.println("push");
        //new String instance
        LinkedStack<String> instance = new LinkedStack<>();
        assertEquals(instance.isEmpty(), true);
        String expResult = "Hello";
        instance.push(expResult);//push
        String result = instance.peek();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testPeek() throws Exception {
        System.out.println("peek");
          //new String instance
        LinkedStack<String> instance = new LinkedStack<>();
        assertEquals(instance.isEmpty(), true);
        String expResult = "Hello";
        instance.push(expResult);//push
        String result = instance.peek();//get pop
        assertEquals(expResult, result);
    }
    
}
