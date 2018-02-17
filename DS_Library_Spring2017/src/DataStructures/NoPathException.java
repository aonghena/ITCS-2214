/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * An exception class for a Graph. Used when no path exists between two nodes.
 * @author Brian Thompson
 * @version 2017/11/15
 */
public class NoPathException extends Exception {
    public NoPathException(GraphNode s, GraphNode d) {
        super("There is no path between " + s + " and " + d);
    }
}
