/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clatulip
 */
public class SearchingTest {

    private final Integer[] intArray = {2, 5, 6, 8, 12, 17, 3, 45, 29, 88, 76, 54, 1, 12, 5, 41, 12, 99};

    /**
     * Test of linearSearch method, of class Searching.
     */
    @Test
    public void testLinearSearch() {
        System.out.println("Testing LinearSearch");
        boolean result = Searching.linearSearch(intArray, (Integer) 3);
        assertTrue(result);
        result = Searching.linearSearch(intArray, (Integer) 52);
        assertFalse(result);
    }

    /**
     * Test of linearSearch2 method, of class Searching.
     */
    @Test
    public <T extends Comparable> void testLinearSearch2() {

        System.out.println("Testing LinearSearch2");
        Integer result = Searching.linearSearch2(intArray, (Integer) 3);
        assertEquals(result, (Integer) 3);
        result = Searching.linearSearch2(intArray, (Integer) 52);
        assertEquals(result, null);
    }

    /**
     * Test of linearSearch3 method, of class Searching.
     */
    @Test
    public void testLinearSearch3() {
        System.out.println("Testing LinearSearch3");
        int[] result = Searching.linearSearch3(intArray, (Integer) 2);
        int[] exp = {0};
        for (int x = 0; x < exp.length; x++) {
            assertEquals(result[x], exp[x]);
        }
        int[] exp1 = {4,13};
        int[] result1 = Searching.linearSearch3(intArray, (Integer) 12);
        for (int x = 0; x < exp.length; x++) {
            assertEquals(result[x], exp[x]);
        }
        
        
    }

}
