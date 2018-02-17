/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/**
 * A fully-featured undirected, unweighted Graph that uses an adjacency 
 * list implementation.
 *
 * @author Brian Thompson
 * @version 2017/11/11
 * @param <T>
 */
public class ALGraph<T> implements A4GraphADT<T> {

    protected int numVertices;
    protected ArrayList<LinkedList<GraphNode>> adjList;
    protected ArrayList<GraphNode> vertices;
    protected int numEdges;

    /**
     * Default Constructor for Graph class.
     */
    public ALGraph() {

        numEdges = 0;   //keeps track of the total number of edges
        numVertices = 0;    //keeps track of the total number of vertices
        vertices = new ArrayList<>();   //holds vertices
        adjList = new ArrayList<>();    //holds LinkedLists of edges

    }

    @Override
    public int size() {
        return numVertices;
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }
    
    /**
     * Takes a generic element, creates a graph node, and adds the node to
     * the graph.
     * @param element a generic element
     */
    @Override
    public void addVertex(T element) {
        if (element != null) {
            GraphNode node = new GraphNode(element);
            this.addVertex(node);
        }
    }

    /**
     * Adds a vertex to the graph. Also adds the vertex to the vertices
     * ArrayList and adds a new LinkedList for the specific vertex to the ArrayList
     * of adjacency lists. Increments numVertices.
     * 
     * @param node passed in node to add to the graph
     */
    @Override
    public void addVertex(GraphNode node) {

        //sets the vertexID to the current size ArrayList
        //thus, we can assume elements have IDs that correspond to the order
        //in which they were added.
        node.setVertexID(numVertices);  
        //add the adjacency list for new vertex to adj list ArrayList
        // vertexID will correspond to the slot in the adjacency Lists ArrayList
        // i.e. node 0's adjList is adjList.get(0)
        LinkedList<GraphNode> edges = new LinkedList<>();
        vertices.add(node);     //add to the vertex to vertices ArrayList
        adjList.add(edges);     //add list of adjacent nodes to adjList
        numVertices++;          //increment number of vertices

    }
    
    /**
     * Removes a vertex from the graph.
     * 
     * @param node the node to be removed.
     * @throws EmptyCollectionException if the collection has no vertices
     * @throws NoSuchElementException if the node doesn't exist
     */
    @Override
    public void removeVertex(GraphNode node) throws EmptyCollectionException, 
            NoSuchElementException {
        
        if (numVertices == 0) {
            throw new EmptyCollectionException("removeVertex-Graph");
        }
        
        if (!vertices.contains(node)) {
            throw new NoSuchElementException(node);
        }
        
        //Remove all edges associated with the node we're removing
        LinkedList<GraphNode> temp = adjList.get(node.getVertexID());
        for (GraphNode n : temp) {
            try {
                this.removeEdge(n, node);
            } catch (NoEdgeExistsException ex) {
                System.out.println(ex);
            }
        }
        
        adjList.remove(node.getVertexID());     //remove the node's adjList
        vertices.remove(node);                  //remove the vertex
        numVertices--;                          //decrement numVertices
    }

    /**
     * Adds an undirected edge between two vertices.
     *
     * @param source the originating node
     * @param destination the ending node
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the nodes don't exist
     * 
     */
    @Override
    public void addEdge(GraphNode source, GraphNode destination)
            throws EmptyCollectionException, NoSuchElementException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("addEdge-Graph");
        }

        if (!vertices.contains(source)) {
            throw new NoSuchElementException(source);
        }

        if (!vertices.contains(destination)) {
            throw new NoSuchElementException(destination);
        }

        //add the node to each node's internal edge list.
        source.addConnectedNode(destination);
        destination.addConnectedNode(source);

        //add each node to each node's adjacency list
        adjList.get(source.getVertexID()).addFirst(destination);
        adjList.get(destination.getVertexID()).addFirst(source);
        numEdges++;

    }
    
    public void removeEdge(GraphNode source, GraphNode destination) throws
            EmptyCollectionException, NoSuchElementException, 
            NoEdgeExistsException {
        if (numVertices == 0) {
            throw new EmptyCollectionException("removeEdge-Graph");
        }

        if (!vertices.contains(source)) {
            throw new NoSuchElementException(source);
        }

        if (!vertices.contains(destination)) {
            throw new NoSuchElementException(destination);
        }
        
        if (!hasEdgeBetween(source, destination)) {
            throw new NoEdgeExistsException();
        }
        
        //remove the edge from each node's internal list of edges
        source.removeConnectedNode(destination);
        destination.removeConnectedNode(source);
        
        //remove edge from each node's adjList
        adjList.get(source.getVertexID()).remove(destination);
        adjList.get(destination.getVertexID()).remove(source);
        
        numEdges--;
    }

    /**
     * Prints out the graph by vertex and its adjacency list in order.
     * Replaces toString method.
     */
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Adjacency List of vertex: " + i);
            System.out.print(vertices.get(i).toString());
            for (GraphNode v : adjList.get(i)) {
                System.out.print("-> " + v.toString());
            }
            System.out.println("\n");
        }
    }

    /**
     * Getter for number of vertices
     *
     * @return number of vertices
     */
    public int getNumVertices() {
        return this.numVertices;
    }

    /**
     * Getter for number of edges
     *
     * @return number of edges
     */
    public int getNumEdges() {
        return this.numEdges;
    }

    /**
     * Gets vertex with highest degree.
     *
     * @return node with the highest degree (most edges)
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoEdgeExistsException if the there are no edges yet
     */
    @Override
    public GraphNode<T> getHighestDegreeVertex()
            throws EmptyCollectionException, NoEdgeExistsException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("getHigestDegreeVertex - Graph");
        }

        if (numEdges == 0) {
            throw new NoEdgeExistsException();
        }

        int highest = 0;
        GraphNode temp = vertices.get(0);

        //Linear search for highest degree vertex
        for (LinkedList<GraphNode> l : adjList) {
            if (l.size() > highest) {
                highest = l.size();
                temp = vertices.get(adjList.indexOf(l));

            }
        }

        return temp;

    }

    /**
     * Gets all the edges from one vertex (the adj list for that vertex).
     *
     * @param node the node to get the edges list for.
     * @return Linked list of edges
     * @throws NoSuchElementException if the node doesn't exist
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoEdgeExistsException if the node has no edges
     */
    @Override
    public LinkedList<GraphNode> getEdgesOfVertex(GraphNode node)
            throws NoSuchElementException, EmptyCollectionException,
            NoEdgeExistsException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("getEdgesOfVertex - Graph");
        }

        if (!vertices.contains(node)) {
            throw new NoSuchElementException(node);
        }

        if (adjList.get(node.getVertexID()).isEmpty()) {
            throw new NoEdgeExistsException(node);
        }

        return adjList.get(node.getVertexID());
    }

    /**
     * Gets the number of edges of one vertex.
     *
     * @param node
     * @return the degree of node
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the node doesn't exist
     */
    @Override
    public int getDegree(GraphNode node) throws EmptyCollectionException,
            NoSuchElementException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("getDegree - Graph");
        }

        if (!vertices.contains(node)) {
            throw new NoSuchElementException(node);
        }

        return adjList.get(node.getVertexID()).size();
    }

    /**
     * Determines if there is an edge between two nodes.
     *
     * @param s the source node
     * @param d the destination node
     * @return true/false if there is an edge between two nodes
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if either node doesn't exist
     */
    @Override
    public boolean hasEdgeBetween(GraphNode s, GraphNode d)
            throws EmptyCollectionException, NoSuchElementException {
        if (numVertices == 0) {
            throw new EmptyCollectionException("hasEdgeBetween - Graph");
        }

        if (!vertices.contains(s)) {
            throw new NoSuchElementException(s);
        }

        if (!vertices.contains(d)) {
            throw new NoSuchElementException(d);
        }

        return adjList.get(s.getVertexID()).contains(d);
    }

    /**
     * Determines if there is a path between two nodes using breadth 
     * first search.
     *
     * @param s the source node
     * @param d the destination node
     * @return true/false if there is a path between two nodes
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the nodes don't exist
     */
    @Override
    public boolean hasPathBetween(GraphNode s, GraphNode d) throws
            EmptyCollectionException, NoSuchElementException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("hasPathBetween - Graph");
        }

        if (!vertices.contains(s)) {
            throw new NoSuchElementException(s);
        }

        if (!vertices.contains(d)) {
            throw new NoSuchElementException(d);
        }

        //set up the traversal queue and the visited array
        boolean[] visited = new boolean[vertices.size()];
        Queue<Integer> traversalQueue = new LinkedList<>();

        
        //add the starting node to the traversal queue and set
        //its slot in the visited array to true
        traversalQueue.add(s.getVertexID());
        visited[s.getVertexID()] = true;

        while (!traversalQueue.isEmpty()) {
            int vertex = traversalQueue.poll();

            //for every neighbor of the current node
            for (GraphNode node : adjList.get(vertex)) {
                if (node.getVertexID() == d.getVertexID()) {
                    return true;    //if we found the target, return true
                }
                //otherwise, if the node hasn't been visited, add it to the queue
                //and mark it as visited
                if (!visited[node.getVertexID()]) {
                    traversalQueue.add(node.getVertexID());
                    visited[node.getVertexID()] = true;
                }

            }
        }
        //if the goal wasn't found, return false
        return false;
    }

    /**
     * Gets a path between two nodes using a breadth first search.
     *
     * @param s the source node
     * @param d the destination node
     * @return a list of the nodes on the path between them.
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the nodes don't exist.
     * @throws NoPathException if there is no path between the two nodes.
     */
    @Override
    public ArrayList<GraphNode> getPathBetween(GraphNode s, GraphNode d) throws
            EmptyCollectionException, NoSuchElementException, NoPathException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("getPathBetween - Graph");
        }

        if (!vertices.contains(s)) {
            throw new NoSuchElementException(s);
        }
        if (!vertices.contains(d)) {
            throw new NoSuchElementException(d);
        }

        if (!hasPathBetween(s, d)) {
            throw new NoPathException(s, d);
        }

        //set up visited array, traversalQueue, and resultsList
        boolean[] visited = new boolean[vertices.size()];
        Queue<Integer> traversalQueue = new LinkedList<>();
        ArrayList<GraphNode> resultsList = new ArrayList<>();

        //add the start node to the queue, and set its slot in the visited array
        //to true
        traversalQueue.add(s.getVertexID());
        visited[s.getVertexID()] = true;

        while (!traversalQueue.isEmpty()) {
            int x = traversalQueue.poll();
            //add the node we're inspecting to the results list
            resultsList.add(vertices.get(x));

            //uses an iterator to inspect each neighbor of the current vertex
            Iterator<GraphNode> i = adjList.get(x).listIterator();
            while (i.hasNext()) {
                GraphNode n = i.next();
                
                if (n.equals(d)) {
                    resultsList.add(d); 
                    //if target node, add to resultsList and return
                    return resultsList;
                }
                
                //otherwise, set its slot in the visited array to true
                //and add it to the queue
                if (!visited[n.getVertexID()]) {
                    visited[n.getVertexID()] = true;
                    traversalQueue.add(n.getVertexID());
                }
            }
        }

        //return the path to the target node
        return resultsList;

    }

    /**
     * Determines if the graph is connected using breadth first traversal.
     * 
     *
     * @return true/false if the graph is connected.
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoEdgeExistsException if the graph has no edges
     */
    @Override
    public boolean isGraphConnected() throws EmptyCollectionException,
            NoEdgeExistsException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("getPathBetween - Graph");
        }
        
        if (numEdges == 0) {
            throw new NoEdgeExistsException();
        }

        ArrayList<GraphNode> temp = new ArrayList<>();

        for (GraphNode node : vertices) {
            try {
                temp = bft(node);
            } catch (NoSuchElementException ex) {
                System.out.println(ex);
            }

            if (temp.size() != vertices.size()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a list of a bf traversal from a given source node.
     *
     * @param node the starting node of the bf traversal
     * @return a list of the nodes along the traversal path
     * @throws EmptyCollectionException if the graph is empty
     * @throws NoSuchElementException if the passed in node doesn't exist
     */
    @Override
    public ArrayList<GraphNode> bft(GraphNode node) throws
            EmptyCollectionException, NoSuchElementException {

        if (numVertices == 0) {
            throw new EmptyCollectionException("bfs - Graph");
        }

        if (!vertices.contains(node)) {
            throw new NoSuchElementException(node);
        }

        boolean[] visited = new boolean[vertices.size()];
        Queue<Integer> traversalQueue = new LinkedList<>();
        ArrayList<GraphNode> resultsList = new ArrayList<>();

        traversalQueue.add(node.getVertexID());
        visited[node.getVertexID()] = true;

        while (!traversalQueue.isEmpty()) {
            int x = traversalQueue.poll();
            resultsList.add(vertices.get(x));

            Iterator<GraphNode> i = adjList.get(x).listIterator();
            while (i.hasNext()) {
                GraphNode n = i.next();
                if (!visited[n.getVertexID()]) {
                    visited[n.getVertexID()] = true;
                    traversalQueue.add(n.getVertexID());
                }
            }
        }

        return resultsList;

    }


}
