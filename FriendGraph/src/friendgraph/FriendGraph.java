/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendgraph;

import DataStructures.*;
import java.util.Stack;
import java.util.ArrayList;


/**
 *
 * @author Alex Onghena
 * @version 1.1
 * @param <T> object
 */
public class FriendGraph<T> extends ALGraph<T> implements FriendGraphADT<T> {

    /**
     * This method returns the number of vertices with no edges. verticie has no
     * edge connected to it
     *
     * @return an integer representing the number of vertices with degree 0.
     * @throws EmptyCollectionException if the graph is empty
     */
    @Override
    public int numIsolatedPoints() throws EmptyCollectionException {
        //if empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
        }
        //check for isolated points
        int isolatedPoints = 0;
        for (int x = 0; x < vertices.size(); x++) {
            try {
                if (getDegree(vertices.get(x)) == 0) {
                    isolatedPoints++;
                }
            } 
            catch (NoSuchElementException ex) {
                System.out.print("error");
            }
        }
        return isolatedPoints;
    }

    /**
     * Determines the inclusiveness of the graph.
     *
     * Inclusivity is a ratio of the number of nodes with edges to total nodes.
     *
     * @return connectedNodes/totalNodes
     * @throws EmptyCollectionException if the graph is empty
     */
    @Override
    public float inclusivity() throws EmptyCollectionException {
        //if empty exception
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
        }
        //get all connectedNodes
        int connectNum = 0;
        for (int x = 0; x < vertices.size(); x++) {
            try {
                if (getDegree(vertices.get(x)) > 0) {
                    connectNum++;
                }
            } 
            catch (NoSuchElementException e) {
                System.out.println("shouldnt print");
            }
        }
        return (float) connectNum / vertices.size();
    }

    /**
     * Determines the density of the graph.
     *
     * The density is a ratio of the total number of edges to the total number
     * of possible edges. For reference, we can determine the total number of
     * possible edges as such: n(n-1)/ 2
     *
     * @return totalEdges/totalPossibleEdges
     * @throws EmptyCollectionException if the graph is empty
     */
    @Override
    public float density() throws EmptyCollectionException {
        //if empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
        }
        //return ratio
        return (float) numEdges / ((this.size()
                * (this.size() - 1)) / 2);
    }

    /**`
     * Determines if the graph is complete. A complete graph has an edge between
     * every node and every other node.
     *
     * @return true/false if the graph is complete.
     * @throws EmptyCollectionException if the graph is empty
     */
    @Override
    public boolean isGraphComplete() throws EmptyCollectionException {
        //if empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
        }
        //if density is == 1 then complete
        return (density() == 1);
    }

    /**
     * A basic depth first traversal. You can implement this method iteratively
     * or recursively. Doing a recursive implementation will grant you bonus
     * points. Keep in mind, however, that implementing this method recursively
     * will likely require a private helper method.
     *
     *
     * @param start the source node
     * @return an ArrayList of the dft starting from the source node
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the source node does not exist
     * @throws NoEdgeExistsException if the graph has no edges
     */
    @Override
    public ArrayList<GraphNode>
            dft(GraphNode start) throws EmptyCollectionException,
            NoSuchElementException, NoEdgeExistsException {
        //if empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
            //if DNE
        } 
        else if (!this.vertices.contains(start)) {
            throw new NoSuchElementException(start);
        }
        //if no edges
        if (numEdges == 0) {
            throw new NoEdgeExistsException();
        }
        
        Stack<GraphNode> stack = new Stack<>();
        stack.add(start);
        ArrayList<GraphNode> vist = new ArrayList<>();
        ArrayList<GraphNode> e = new ArrayList<>();
        vist.add(start);
        while (!stack.isEmpty()) {
            //adds to ArrayList
            e.add(stack.peek());            
            GraphNode element = stack.pop();
            ArrayList<GraphNode> connections = element.getConnectedNodes();
            //Loop through connection
            for (int x = 0; x < connections.size(); x++) {
                GraphNode y = connections.get(x);
                //add to stack and vist
                if (!vist.contains(y)) {
                    stack.add(y);
                    vist.add(y);
                }
            }
            
        }
        return e;
    }

    /**
     * A method to determine if we should suggest a person as a friend to
     * another person. If Person A and Person B have at least two mutual
     * friends, but don't already have an edge between them, return true.
     * Otherwise return false.
     *
     * Pseudocode: throw appropriate exceptions. if Person A and Person B are
     * already friends, return false. if Person A has at least two friends
     * (neighbors) that have edges with Person B, return true. Otherwise, return
     * false.
     *
     *
     *
     * @param s Person A
     * @param d Person B
     * @return true/false if we should suggest the friend
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the passed in nodes don't exist
     */
    @Override
    public boolean suggestFriend(GraphNode s, GraphNode d)
            throws EmptyCollectionException, NoSuchElementException {
        //catches errors
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
        } 
        else if (!this.vertices.contains(s)) {
            throw new NoSuchElementException(s);
        } 
        else if (!this.vertices.contains(d)) {
            throw new NoSuchElementException(d);
        }
        //if edge
        if (hasEdgeBetween(s, d)) {
            return false;
        }
        int friends = 0;
        //get connected mutual freinds
        for (int x = 0; x < s.getConnectedNodes().size(); x++) {
            if (hasEdgeBetween(((GraphNode) s.getConnectedNodes().get(x)), d)) {
                friends++;
            }
        }

        return friends > 1;
    }

    /**
     * If there is a path between two nodes, they should be able to message each
     * other.
     *
     * @param s source node
     * @param d destination node
     * @return true/false if there is a path between them
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if either node doesn't exist
     */
    @Override
    public boolean canMessage(GraphNode s, GraphNode d)
            throws EmptyCollectionException, NoSuchElementException {
        //catch error
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
        } 
        else if (!this.vertices.contains(s)) {
            throw new NoSuchElementException(s);
        } 
        else if (!this.vertices.contains(d)) {
            throw new NoSuchElementException(d);
        }
        return hasPathBetween(s, d);
    }

    /**
     * If there is an edge between two nodes, they should be able to post to
     * each others' walls.
     *
     * @param s source node
     * @param d destination node
     * @return true/false if there is an edge between them
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the nodes don't exist.
     */
    @Override
    public boolean canPostTo(GraphNode s, GraphNode d)
            throws EmptyCollectionException, NoSuchElementException {
        //catch error
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Error");
        } 
        else if (!this.vertices.contains(s)) {
            throw new NoSuchElementException(s);
        } 
        else if (!this.vertices.contains(d)) {
            throw new NoSuchElementException(d);
        }

        return hasEdgeBetween(s, d);
    }

}
