/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Modified version of an exception class used in earlier semesters for graph
 * programming assignments. Used when a node does not exist in the graph. 
 * @author Brian Thompson, Celine Latulipe, Manuel Perez
 * @version 2017/11/15
 */
public class NoSuchElementException extends Exception {
    public NoSuchElementException(GraphNode el) {
        super("The element " + el + " was not found in the collection.");
    }
}
