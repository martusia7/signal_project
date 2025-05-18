package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;
/**
 * Interface for generating patient data
 */
public interface PatientDataGenerator {

    /**
     * Generates and outputs data for a patient
     * 
     * @param patientId An identifier for a patient
     * @param outputStrategy the output startegy for displaying or storing data
     */
    void generate(int patientId, OutputStrategy outputStrategy);
}
