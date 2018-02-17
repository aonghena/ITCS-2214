/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * An exception class for graphs. Used when an edge doesn't exist, a node has no
 * edges, or a graph has no edges.
 * @author Brian Thompson
 * @version 2017/11/15
 */
public class NoEdgeExistsException extends Exception {
    public NoEdgeExistsException(GraphNode node1, GraphNode node2) {
        super("No Edge exists between " + node1 + " and " + node2);
    }
    
    public NoEdgeExistsException(GraphNode node) {
        super("This node doesn't have any edges!");
    }
   
    
    public NoEdgeExistsException() {
        super("This graph does not have any edges yet.");
    }
    
}
