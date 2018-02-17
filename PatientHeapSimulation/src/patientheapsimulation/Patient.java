/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientheapsimulation;

import java.time.LocalTime;

/**
 *
 * @author clatulip
 * @version 2017-10-27
 */
public class Patient implements Comparable<Patient> {

    /**
     * Enumerated type to classify patient's condition.
     *
     */
    public enum Status {
        /**
         * Healthy condition
         */
        HEALTHY,
        /**
         * Minor issue
         */
        MINOR,
        /**
         * Serious condition
         */
        SERIOUS,
        /**
         * Critical condition
         */
        CRITICAL,
        /**
         * Severe condition
         */
        SEVERE
    }

    private String name;
    private int id;
    private Status status;
    private LocalTime arrival;

    /**
     * compareTo
     * compare status, if the status is the same, then compare arrival time
     * @param o patient to do comparison with
     * @return number if greater or less than
     */
    @Override
    public int compareTo(Patient o) {
        
        if (this.status.compareTo(o.status) != 0) {
            return this.status.compareTo(o.status);
        } 
        else {
            return (-1 * this.arrival.compareTo(o.arrival));
        }

    }

    /**
     * Constructor for class Patient.
     *
     * @param name name of patient
     * @param status patient's status
     */
    public Patient(String name, Status status) {
        this.name = name;
        this.status = status;
        this.arrival = LocalTime.now();
        id = (int) (Math.random() * 200000);
    }

    /**
     * Getter for status.
     *
     * @return patient's status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setter for status.
     *
     * @param s patient's status
     */
    public void setStatus(Status s) {
        this.status = s;
    }

    /**
     * Getter for patient's name
     *
     * @return patient's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for patient id.
     *
     * @return patients id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for arrival time.
     *
     * @return time of arrival to hospital sim
     */
    public LocalTime getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", id=" + id + ", status="
                + status + ", arrival=" + arrival + " }";

    }

}
