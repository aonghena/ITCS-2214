/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;

/**
 * GraphNode class for use with ALGraph.java.
 * @author Brian Thompson
 * @version 2017/11/15
 * @param <T> generic element
 */
public class GraphNode<T> {
    
    private T element;
    private int vertexID;
    private ArrayList<GraphNode> connectedNodes;
    
    
    public GraphNode(T name) {
        element = name;
        vertexID = -1; //initialized to -1 to show an invalid vertex
        connectedNodes = new ArrayList<>();
        
    }
    
    public GraphNode(T name, int id) {
        element = name;
        vertexID = id;
        connectedNodes = new ArrayList<>();
        
    }
    
    public ArrayList<GraphNode> getConnectedNodes() {
        return this.connectedNodes;
    }
    
    public boolean addConnectedNode(GraphNode node) {
        return this.connectedNodes.add(node);
    }
    
    public boolean removeConnectedNode(GraphNode node) {
        return this.connectedNodes.remove(node);
    }
    
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getVertexID() {
        return this.vertexID;
    }

    public void setVertexID(int vertex) {
        this.vertexID = vertex;
    }
    
    @Override
    public String toString() {
        return "{Element: " + element + ", vertexID: " + vertexID + "}";
    }

    
    
    @Override
    public boolean equals (Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof GraphNode)) return false;
        GraphNode n = (GraphNode) o;
        return this.vertexID == n.getVertexID();
    }
    
}
