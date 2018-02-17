/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendgraph;

import DataStructures.GraphNode;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 * @version 1.1
 */
public class FriendGraphTest {


    /**
     * Test of numIsolatedPoints method, of class FriendGraph.
     */
    @Test
    public void testNumIsolatedPoints() throws Exception {
        System.out.println("numIsolatedPoints");
        FriendGraph instance = new FriendGraph();
        try {
            instance.numIsolatedPoints();
            assertEquals(instance.size(), -1);
        } 
        catch (Exception e) {
            assertEquals(instance.size(), 0);
        }
        
        GraphNode brian = new GraphNode("Brian");
        instance.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        
        int result = instance.numIsolatedPoints();
        assertEquals(0, result);
        
        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        
        result = instance.numIsolatedPoints();
        assertEquals(1, result);
        

        
        
    }

    /**
     * Test of inclusivity method, of class FriendGraph.
     */
    @Test
    public void testInclusivity() throws Exception {
        System.out.println("inclusivity");
        FriendGraph instance = new FriendGraph();
        
        try {
            instance.inclusivity();
            assertEquals(instance.size(), -1);
        } 
        catch (Exception e) {
            assertEquals(instance.size(), 0);
        }

        
        GraphNode brian = new GraphNode("Brian");
        instance.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        
        float result = instance.inclusivity();
        
        assertEquals(1.0, result, 0.0F);
        

        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        result = instance.inclusivity();

        assertEquals(.6666666, result, 0.2F);
        

    }

    /**
     * Test of density method, of class FriendGraph.
     */
    @Test
    public void testDensity() throws Exception {
        System.out.println("density");
        FriendGraph instance = new FriendGraph();
        //test for error handleing
        try {
            instance.density();
            assertEquals(instance.size(), -1);
        } 
        catch (Exception e) {
            assertEquals(instance.size(), 0);
        }
        

        
        GraphNode brian = new GraphNode("Brian");
        instance.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        
  
        float result = instance.density();
        assertEquals(0.0F, result, 1);
        
        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        result = instance.density();
        
        assertEquals(.33333, result, 0.2F);
        

    }

    /**
     * Test of isGraphComplete method, of class FriendGraph.
     */
    @Test
    public void testIsGraphComplete() throws Exception {
        System.out.println("isGraphComplete");
        FriendGraph instance = new FriendGraph();

        
        GraphNode brian = new GraphNode("Brian");
        instance.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        

        boolean result = instance.isGraphComplete();
        assertEquals(true, result);
        
        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        result = instance.isGraphComplete();
        
        assertEquals(false, result);

    }

    /**
     * Test of dft method, of class FriendGraph.
     */
    @Test
    public void testDft() throws Exception {
        System.out.println("dft");
        
        
        FriendGraph instance = new FriendGraph();
        
        GraphNode brian = new GraphNode("Brian");
        try {
            instance.dft(brian);
            assertEquals(instance.size(), -1);
        } 
        catch (Exception e) {
            assertEquals(instance.size(), 0);
        }
        instance.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        ArrayList<GraphNode> expResult = new ArrayList<>();
        expResult.add(brian);
        expResult.add(mariah);
        ArrayList<GraphNode> result ;
        instance.dft(brian);
        
 
        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        instance.addEdge(brian, yodhep);
        
        expResult.add(1, yodhep);
        result = instance.dft(brian);
        assertEquals(expResult, result);
        
        GraphNode olaf = new GraphNode("Olaf");
        instance.addVertex(olaf);
        instance.addEdge(mariah, olaf);
        
        GraphNode mo = new GraphNode("mo");
        instance.addVertex(mo);
        instance.addEdge(olaf, mo);
        
        expResult.add(olaf);
        expResult.add(mo);
        
        result = instance.dft(brian); 
        assertEquals(expResult, result);
    }

    /**
     * Test of suggestFriend method, of class FriendGraph.
     */
    @Test
    public void testSuggestFriend() throws Exception {
        FriendGraph instance = new FriendGraph();
        GraphNode brian = new GraphNode("Brian");
        instance.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        
        boolean result = instance.suggestFriend(brian, mariah);
        assertEquals(false, result);
        
        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        instance.addEdge(yodhep, brian);
        result = instance.suggestFriend(yodhep, mariah);
        assertEquals(false, result);
        
        GraphNode olaf = new GraphNode("Olaf");
        instance.addVertex(olaf);
        instance.addEdge(olaf, yodhep);
        instance.addEdge(olaf, mariah);
        result = instance.suggestFriend(yodhep, mariah);
        assertEquals(true, result);
    }

    /**
     * Test of canMessage method, of class FriendGraph.
     */
    @Test
    public void testCanMessage() throws Exception {
        System.out.println("canMessage");
        FriendGraph instance = new FriendGraph();
        
        try {
            instance.canMessage(null, null);
            assertEquals(instance.size(), -1);
        } 
        catch (Exception e) {
            assertEquals(instance.size(), 0);
        }
        
        GraphNode brian = new GraphNode("Brian");
        instance.addVertex(brian);
        GraphNode mariah = new GraphNode("Mariah");
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        
        boolean result = instance.canMessage(brian, mariah);
        assertEquals(true, result);
        
        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        result = instance.canMessage(yodhep, mariah);
        assertEquals(false, result);
        instance.addEdge(yodhep, brian);
        result = instance.canMessage(yodhep, mariah);
        assertEquals(true, result);
    }

    /**
     * Test of canPostTo method, of class FriendGraph.
     */
    @Test
    public void testCanPostTo() throws Exception {
        System.out.println("canPostTo");
        FriendGraph instance = new FriendGraph();
        GraphNode brian = new GraphNode("Brian");
        GraphNode mariah = new GraphNode("Mariah");
        try {
            instance.canPostTo(brian, mariah);
            assertEquals(instance.size(), -1);
        } 
        catch (Exception e) {
            assertEquals(instance.size(), 0);
        }
        
        
        
        instance.addVertex(brian);
        
        instance.addVertex(mariah);
        instance.addEdge(brian, mariah);
        
        boolean result = instance.canPostTo(brian, mariah);
        assertEquals(true, result);
        
        GraphNode yodhep = new GraphNode("Yodhep");
        instance.addVertex(yodhep);
        result = instance.canPostTo(yodhep, mariah);
        assertEquals(false, result);
        instance.addEdge(yodhep, brian);
        result = instance.canPostTo(yodhep, mariah);
        assertEquals(false, result);
        
    }
    
}
