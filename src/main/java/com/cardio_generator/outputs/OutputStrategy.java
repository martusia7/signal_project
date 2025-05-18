package com.cardio_generator.outputs;

/**
 * Interface for output strategies that defines a method for outputting patient data
 * in a standardized way
 */
public interface OutputStrategy {

    /**
     * Outputs data for a specific patient 
     *  
     * @param patientId An identifier for a patient
     * @param timestamp the time when the data is recorded
     * @param label describes the type of data
     * @param data the value of the data
     */
    void output(int patientId, long timestamp, String label, String data);
}
