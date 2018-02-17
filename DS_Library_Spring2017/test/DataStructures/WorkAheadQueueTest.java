package DataStructures;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex Onghena
 * Test WorkAheadQueue
 * @version 1.1
 */
public class WorkAheadQueueTest {
    
    public WorkAheadQueueTest() {
    }

    /**
     * Test of enqueue method, of class WorkAheadQueue.
     */
    @Test
    public void testEnqueue() throws Exception {
        System.out.println("enqueue");
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        assertEquals(instance.toString(), "1");
        
        instance.enqueue(3);
        //check that elements are what we expect from enqueue above metod
        assertEquals(instance.toString(), "1, 3");
        
        //check using String
        WorkAheadQueue instance1 = new WorkAheadQueue();
        instance1.enqueue("buy bitcoin");
        assertEquals(instance1.toString(), "buy bitcoin");
        
    }

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     * @throws Exception
     */
    @Test
    public void testDequeue_0args() throws Exception {
        System.out.println("dequeue");
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(11);
        instance.enqueue(31);
        instance.enqueue(5651);
        assertEquals(instance.dequeue(), 11);
        
        //check using String
        WorkAheadQueue instance1 = new WorkAheadQueue();
        instance1.enqueue("buy bitcoin");
        assertEquals(instance1.dequeue(), "buy bitcoin");
        assertEquals(instance1.isEmpty(), true);

        //used to make sure that proper catch is used.
        try{
            instance1.dequeue();
            //if this works something will be wrong
            assertFalse(false);
        }catch(EmptyCollectionException e){
            assertTrue(true);
        }
    }

    /**
     * Test of first method, of class WorkAheadQueue.
     * @throws Exception
     */
    @Test
    public void testFirst_0args() throws Exception {
        System.out.println("first");
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        instance.enqueue(45);
        assertEquals(instance.first(), 1);
        assertEquals(instance.size(), 2);
        
        //check using String       
        WorkAheadQueue instance1 = new WorkAheadQueue();
        instance1.enqueue("buy bitcoin");
        assertEquals(instance1.first(), "buy bitcoin");
        assertEquals(instance1.size(), 1);
        
        
    }

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    @Test
    public void testDequeue_int() throws Exception {
        System.out.println("dequeue");
        
        //check using int
        int x = 1;
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(6);
        instance.enqueue(2);
        instance.enqueue(50);
        
        assertEquals(instance.dequeue(x), 2);

        assertEquals(instance.firstFive().size(), 2);
        
        assertEquals(instance.dequeue(x), 50);
        
        assertEquals(instance.dequeue(0), 6);
        
        assertEquals(instance.size(), 0);
        
        
       
        //check using String       
        x = 1;
        WorkAheadQueue instance1 = new WorkAheadQueue();
       
        instance1.enqueue("buy bitcoin");
        instance1.enqueue("nah");
        
        assertEquals(instance1.dequeue(x), "nah");
        assertEquals(instance1.toString(), "buy bitcoin");
        assertEquals(instance1.size(), 1);
        
        //used to make sure that proper catch is used.
        try{
            instance1.dequeue(45);
            //if this works something will be wrong
            assertFalse(false);
        }catch(EmptyCollectionException | InvalidArgumentException e){
            assertTrue(true);
        }    

    }

    /**
     * Test of first method, of class WorkAheadQueue.
     */
    @Test
    public void testFirst_int() throws Exception {
        System.out.println("first");
        int x = 1;
        
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        instance.enqueue(45);
        assertEquals(instance.first(1), 45);
        assertEquals(instance.size(), 2);
        
        //check using String       
        WorkAheadQueue instance1 = new WorkAheadQueue();
        instance1.enqueue("buy bitcoin");
        assertEquals(instance1.first(0), "buy bitcoin");
        assertEquals(instance1.size(), 1);
        
        //used to make sure that proper catch is used.
        try{
            instance1.first(10);
            //if this works something will be wrong
            assertFalse(false);
        }catch(EmptyCollectionException | InvalidArgumentException e){
            assertTrue(true);
        }  
    }

    /**
     * Test of firstFive method, of class WorkAheadQueue.
     */
    @Test
    public void testFirstFive() throws Exception {
        System.out.println("firstFive");
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        String s = instance.firstFive().toString();
        assertEquals(s, "[{el=1, next=null, prev=null}]");
        
        //check using string
        WorkAheadQueue instance1 = new WorkAheadQueue();
        instance1.enqueue("Buy Bitcoin");
        s = instance1.firstFive().toString();
        assertEquals(s, "[{el=Buy Bitcoin, next=null, prev=null}]");
    }

    /**
     * Test of isEmpty method, of class WorkAheadQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        boolean expResult = false;
        assertEquals(!expResult, instance.isEmpty());
        
        instance.enqueue(0);
        assertEquals(expResult, instance.isEmpty());
        
        //check using string
        WorkAheadQueue instance1 = new WorkAheadQueue();
        instance1.enqueue("Buy Bitcoin");
        assertEquals(instance1.isEmpty(), false);
    }

    /**
     * Test of size method, of class WorkAheadQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        assertEquals(instance.size(), 1);
        
        //check using string       
        WorkAheadQueue instance1 = new WorkAheadQueue();       
        assertEquals(instance1.size(), 0);

    }

    /**
     * Test of toString method, of class WorkAheadQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        //check using int
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        instance.enqueue(2);
        String expResult = "1, 2";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        //check using string
        WorkAheadQueue instance1 = new WorkAheadQueue();
        instance1.enqueue("buy bitcoin");
        expResult = "buy bitcoin";
        result = instance1.toString();
        assertEquals(expResult, result);
    }
    
}
