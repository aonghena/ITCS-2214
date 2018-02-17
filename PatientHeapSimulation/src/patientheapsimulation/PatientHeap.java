/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientheapsimulation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clatulip
 */
public class PatientHeap {


    private ArrayHeap<Patient> heap;

    public PatientHeap() {
        heap = new ArrayHeap<>();
    }
    
    public void addPatient(Patient p) {
        heap.addElement(p);
    }
    
    public void addPatient(String name, Patient.Status status) {
        System.out.println("Adding Patient");
        heap.addElement(new Patient(name, status));
    }
    
    public void treatNextPatient() {
        System.out.println("Treating patients.");
        if (!heap.isEmpty()) {
            try {
                Patient p = heap.removeMax();
                System.out.println("Treating patient: " + p.toString());
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(PatientHeap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int numPatientsWaiting() {
        return heap.size();
    }
}
