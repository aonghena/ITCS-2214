/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientheapsimulation;

import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex Onghena
 * @version 1.1
 */
public class PatientTest {

    /**
     * Test of compareTo method, of class Patient.
     */
    @Test
    public void testCompareTo() throws InterruptedException {
        System.out.println("compareTo");
        //Test Different Status Comparison
        Patient o = new Patient("John", Patient.Status.HEALTHY);
        Patient i = new Patient("Linsey", Patient.Status.SEVERE);
        assertTrue(o.compareTo(i) < 0);
        assertFalse(o.compareTo(i) > 0);
        
        //Test Different Times (Same Status
        o = new Patient("James", Patient.Status.MINOR);
        Thread.sleep(300);
        i = new Patient("Lauren", Patient.Status.MINOR);

        assertTrue(o.compareTo(i) > 0);

    }

    /**
     * Test of getStatus method, of class Patient.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Patient o = new Patient("John", Patient.Status.HEALTHY);
        Patient i = new Patient("Linsey", Patient.Status.SEVERE);
        assertEquals(i.getStatus(), Patient.Status.SEVERE);
        assertEquals(o.getStatus(), Patient.Status.HEALTHY);
    }

    /**
     * Test of setStatus method, of class Patient.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Patient o = new Patient("John", Patient.Status.HEALTHY);
        Patient i = new Patient("Linsey", Patient.Status.SEVERE);
        o.setStatus(Patient.Status.MINOR);
        i.setStatus(Patient.Status.HEALTHY);
        assertEquals(i.getStatus(), Patient.Status.HEALTHY);
        assertEquals(o.getStatus(), Patient.Status.MINOR);

    }

    /**
     * Test of getName method, of class Patient.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Patient o = new Patient("John", Patient.Status.HEALTHY);
        Patient i = new Patient("Linsey", Patient.Status.SEVERE);
        assertEquals(o.getName(), "John");
        assertEquals(i.getName(), "Linsey");
    }

    /**
     * Test of getId method, of class Patient.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Patient o = new Patient("John", Patient.Status.HEALTHY);
        Patient i = new Patient("Linsey", Patient.Status.SEVERE);
        //random num, no good way to test
        assertEquals(o.getId(), o.getId());
        assertEquals(i.getId(), i.getId());
    }

    /**
     * Test of getArrival method, of class Patient.
     */
    @Test
    public void testGetArrival() {
        System.out.println("getArrival");
        Patient o = new Patient("John", Patient.Status.HEALTHY);
        Patient i = new Patient("Linsey", Patient.Status.SEVERE);
        assertEquals(o.getArrival(), LocalTime.now());
        assertEquals(i.getArrival(), LocalTime.now());
    }

    /**
     * Test of toString method, of class Patient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Patient o = new Patient("John", Patient.Status.HEALTHY);
        Patient i = new Patient("Linsey", Patient.Status.SEVERE);
        assertTrue(o.toString().contains("John")
                && o.toString().contains("HEALTHY"));
        assertTrue(i.toString().contains("Linsey")
                && i.toString().contains("SEVERE"));

    }        
}
