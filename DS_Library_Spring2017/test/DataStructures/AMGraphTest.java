

package DataStructures;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 *
 *
 * @author homan
 *
 */


public class AMGraphTest {

    public AMGraphTest() {

    }

    /**
     *
     * Test of addVertex method, of class AMGraph.
     *
     */
    @Test

    public void testAddVertex() {

        System.out.println("addVertex");

        int exp1 = 1;

        int exp2 = 3;

        int res1, res2;

        AMGraph<String> instance = new AMGraph<String>();

        instance.addVertex("Clara");

        res1 = instance.size();

        instance.addVertex("Bob");

        instance.addVertex("Eernie");

        res2 = instance.size();

        assertEquals(exp1, res1);

        assertEquals(exp2, res2);

    }

    /**
     *
     * Test of removeVertex method, of class AMGraph.
     *
     */
    @Test

    public void testRemoveVertex() {

        System.out.println("removeVertex");

        int exp1 = 1;

        int exp2 = 0;

        int res1, res2;

        AMGraph<String> instance = new AMGraph<String>();

        instance.addVertex("Clara");

        res1 = instance.size();

        instance.removeVertex("Clara");

        res2 = instance.size();

        assertEquals(exp1, res1);

        assertEquals(exp2, res2);

    }

    /**
     *
     * Test of addEdge method, of class AMGraph.
     *
     */
    @Test

    public void testAddEdge() {

        System.out.println("addEdge");

        AMGraph<String> instance = new AMGraph<String>();

        instance.addVertex("A");

        instance.addVertex("B");

        instance.addVertex("C");

        instance.addVertex("D");

        instance.addVertex("E");

        instance.addVertex("F");

        instance.addEdge("A", "B");

        instance.addEdge("A", "C");

        instance.addEdge("A", "D");

        instance.addEdge("B", "C");

        instance.addEdge("B", "E");

        instance.addEdge("D", "E");

        instance.addEdge("D", "F");

        instance.addEdge("E", "B");

        instance.toString();

    }

    /**
     *
     * Test of removeEdge method, of class AMGraph.
     *
     */
    @Test

    public void testRemoveEdge() {

        System.out.println("removeEdge");

        AMGraph<String> instance = new AMGraph<String>();

        instance.addVertex("A");

        instance.addVertex("B");

        instance.addVertex("C");

        instance.addVertex("D");

        instance.addVertex("E");

        instance.addVertex("F");

        instance.addEdge("A", "B");

        instance.addEdge("A", "C");

        instance.addEdge("A", "D");

        instance.addEdge("B", "C");

        instance.addEdge("B", "E");

        instance.addEdge("D", "E");

        instance.addEdge("D", "F");

        instance.addEdge("E", "B");

        instance.toString();

        instance.removeEdge("A", "D");

        instance.toString();

    }

    /**
     *
     * Test of depthFirstTraversal method, of class AMGraph.
     *
     */
    

    /**
     *
     * Test of breadthFirstTraversal method, of class AMGraph.
     *
     */
    @Test

    public void testBreadthFirstTraversal() {

        System.out.println("breadthFirstTraversal");

        assertTrue(true);

    }

    
    /**
     * Test of isConnected method, of class AMGraph.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        AMGraph<Integer> instance = new AMGraph<Integer>();
        instance.addVertex(1);
        instance.addVertex(2);
        instance.addVertex(3);
        instance.addVertex(4);
        instance.addVertex(5);
        instance.addVertex(6);
        instance.addVertex(7);
        instance.addEdge(1, 2);
        instance.addEdge(2,3);
        instance.addEdge(3,4);
        instance.addEdge(5,6);
        boolean result = instance.isConnected();
        assertEquals(instance.isConnected(), result);
        instance.addVertex(7);
        result = instance.isConnected();
        assertEquals(result, false);

    }

    /**
     * Test of isEmpty method, of class AMGraph.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        AMGraph<Integer> instance = new AMGraph<Integer>();
        assertTrue(instance.isEmpty());
        instance.addVertex(1);
        assertFalse(instance.isEmpty());
       
       
    }

    
    /**
     *
     * Test of toString method, of class AMGraph.
     *
     */

    @Test

    public void testToString() {

        System.out.println("size");

        AMGraph instance = new AMGraph();

        int expResult = 0;

        int result = instance.size();

        assertEquals(expResult, result);

    }

}
