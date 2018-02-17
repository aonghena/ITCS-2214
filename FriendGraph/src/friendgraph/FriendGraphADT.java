/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendgraph;

import DataStructures.EmptyCollectionException;
import DataStructures.GraphNode;
import DataStructures.NoEdgeExistsException;
import DataStructures.NoSuchElementException;
import java.util.ArrayList;

/**
 * The interface for the FriendGraph.
 * @author Brian Thompson
 * @version 2017/11/15
 * @param <T> a generic element
 */
public interface FriendGraphADT<T> {
    
    
    /**
     * This method returns the number of vertices with no edges.
     * 
     * @return an integer representing the number of vertices with degree 0.
     * @throws EmptyCollectionException if the graph is empty
     */
    public int numIsolatedPoints() throws EmptyCollectionException;
    
    /**
     * Determines the inclusiveness of the graph.
     * 
     * Inclusivity is a ratio of the number of nodes with edges to total nodes.
     * @return connectedNodes/totalNodes
     * @throws EmptyCollectionException if the graph is empty
     */
    public float inclusivity() throws EmptyCollectionException;
    
    /**
     * Determines the density of the graph.
     * 
     * The density is a ratio of the total number of edges to the total number
     * of possible edges.
     * For reference, we can determine the total number of possible edges as such:
     * n(n-1)/ 2
     * @return totalEdges/totalPossibleEdges
     * @throws EmptyCollectionException if the graph is empty
     */
    public float density() throws EmptyCollectionException;
    
    /**
     * Determines if the graph is complete. 
     * A complete graph has an edge between every node and every other node.
     * 
     * @return true/false if the graph is complete.
     * @throws EmptyCollectionException if the graph is empty
     */
    public boolean isGraphComplete() throws EmptyCollectionException;
    
    /**
     * A basic depth first traversal.
     * You can implement this method iteratively or recursively. 
     * Doing a recursive implementation will grant you bonus points. 
     * Keep in mind, however, that implementing this method recursively will 
     * likely require a private helper method. 
     * 
     * 
     * @param start the source node
     * @return an ArrayList of the dft starting from the source node
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the source node does not exist
     * @throws NoEdgeExistsException if the graph has no edges
     */
    public ArrayList<GraphNode> dft(GraphNode start) 
            throws EmptyCollectionException, NoSuchElementException,
            NoEdgeExistsException;
    
    /**
     * A method to determine if we should suggest a person as a friend to 
     * another person.
     * If Person A and Person B have at least two mutual friends, but don't
     * already have an edge between them, return true. Otherwise return false.
     * 
     * Pseudocode:
     * throw appropriate exceptions.
     * if Person A and Person B are already friends, return false.
     * if Person A has at least two friends (neighbors) that have edges with 
     * Person B, return true. 
     * Otherwise, return false.
     * 
     * 
     * 
     * @param s Person A
     * @param d Person B
     * @return true/false if we should suggest the friend
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the passed in nodes don't exist
     */
    public boolean suggestFriend(GraphNode s, GraphNode d) throws 
            EmptyCollectionException, NoSuchElementException;
    
    
    /**
     * If there is a path between two nodes, they should be able to message each
     * other.
     * @param s source node
     * @param d destination node
     * @return true/false if there is a path between them
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if either node doesn't exist
     */
    public boolean canMessage(GraphNode s, GraphNode d) 
            throws EmptyCollectionException, NoSuchElementException;
    
    /**
     * If there is an edge between two nodes, they should be able to post to each
     * others' walls.
     * @param s source node
     * @param d destination node
     * @return true/false if there is an edge between them
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the nodes don't exist.
     */
    public boolean canPostTo(GraphNode s, GraphNode d) 
            throws EmptyCollectionException, NoSuchElementException;
}
