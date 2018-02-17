/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Interface for an unweighted Graph.
 * @author Brian Thompson
 * @version 2017/11/15
 * @param <T>
 */
public interface A4GraphADT<T> extends CollectionADT {
    
    public void addVertex(T element);
    
    public void addVertex(GraphNode node);
    
    public void removeVertex(GraphNode node)
            throws EmptyCollectionException, NoSuchElementException;
    
    public void addEdge(GraphNode source, GraphNode destination) 
            throws EmptyCollectionException, NoSuchElementException;
    
    public GraphNode<T> getHighestDegreeVertex() 
            throws EmptyCollectionException, NoEdgeExistsException;
    
    public LinkedList<GraphNode> getEdgesOfVertex(GraphNode node) 
            throws NoSuchElementException, EmptyCollectionException, 
            NoEdgeExistsException;
    
    public int getDegree(GraphNode node) 
            throws NoSuchElementException, EmptyCollectionException;
    
    public boolean hasEdgeBetween(GraphNode s, GraphNode d) 
            throws NoSuchElementException, EmptyCollectionException;
    
    public boolean hasPathBetween(GraphNode s, GraphNode d) 
            throws NoSuchElementException, EmptyCollectionException;
    
    public ArrayList<GraphNode> getPathBetween(GraphNode s, GraphNode d) 
            throws NoSuchElementException, EmptyCollectionException, NoPathException;
    
    
    public boolean isGraphConnected() 
            throws EmptyCollectionException, NoEdgeExistsException;
    
    public ArrayList<GraphNode> bft(GraphNode node) 
            throws EmptyCollectionException, NoSuchElementException;
    
    
}
