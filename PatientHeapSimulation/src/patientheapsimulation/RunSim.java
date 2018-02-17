/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientheapsimulation;

/**
 *
 * @author clatulip
 * @version 1.1
 */
public class RunSim {
    public static void main(String[] args) throws InterruptedException {
        PatientHeap ph = new PatientHeap();
            
        // Add patients
        ph.addPatient("John", Patient.Status.MINOR);
        Thread.sleep(300);
        ph.addPatient("Celine", Patient.Status.HEALTHY);
        Thread.sleep(300);
        ph.addPatient("Byron", Patient.Status.SEVERE);
        Thread.sleep(300);
        ph.addPatient("Abby", Patient.Status.SEVERE);
        Thread.sleep(300);
        ph.addPatient("Colin", Patient.Status.SEVERE);
        Thread.sleep(300);
        ph.addPatient("Adrian", Patient.Status.HEALTHY);
        Thread.sleep(300);
        ph.addPatient("Jay", Patient.Status.SEVERE);
        Thread.sleep(300);
        ph.addPatient("Bonie", Patient.Status.SEVERE);
        Thread.sleep(300);
        while (ph.numPatientsWaiting() > 0) {
            ph.treatNextPatient();
        }
    }
}
