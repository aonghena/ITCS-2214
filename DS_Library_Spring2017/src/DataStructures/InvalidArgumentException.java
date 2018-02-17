package DataStructures;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * An Invalid Argument Exception class.
 * Prints out what method was sent an invalid argument
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2017
 * @author clatulip
 * @version 2017-09-29
 */
public class InvalidArgumentException extends Exception {

    /**
     * Constructor for InvalidArgumentException.
     * Prints out what method was sent an invalid argument.
     * @param method the name of the method that caused the exception
     */
    public InvalidArgumentException(String method) {
        super("The argument sent to " + method + " is invalid.");
    }
    
}
