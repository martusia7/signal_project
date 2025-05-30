package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class imlements {@link OutputStrategy} and writes output data
 * It manages creating files and writing in base directory
 */
//renamed the class so it starts with an uppercase letter
public class FileOutputStrategy implements OutputStrategy { 

    private String baseDirectory;

    /**
     * A map of files with data labels
     */
    // changed the variable name to UPPER_SNAKE_CASE, because its a constant
    public final ConcurrentHashMap<String, String> FILE_MAP = new ConcurrentHashMap<>();

    /**
     * Constructs a new {@code FileOutputStrategy} with a abse directory
     * @param baseDirectory
     */
    //changed the name to start with an uppercase letter
    public FileOutputStrategy(String baseDirectory) {

        //Changed the variable name to camelCase
        this.baseDirectory = baseDirectory;
    }

    /**
     * Outputs data toa file with a specific data label
     * If the file doeasn't exist it creates a new one
     * Every output is formatted
     * 
     * @param patientId An identifier for a patient
     * @param timestamp the time when the data is recorded
     * @param label describes the type of data
     * @param data the value of the data
     */
    @Override
    public void output(int patientId, long timestamp, String label, String data) {
        try {
            // Create the directory
            Files.createDirectories(Paths.get(baseDirectory));
        } catch (IOException e) {
            System.err.println("Error creating base directory: " + e.getMessage());
            return;
        }
        // Set the FilePath variable, changed the variable name
        String filePath = FILE_MAP.computeIfAbsent(label, k -> Paths.get(baseDirectory, label + ".txt").toString());

        // Write the data to the file
        try (PrintWriter out = new PrintWriter(
                Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
        } catch (Exception e) {
            System.err.println("Error writing to file " + filePath + ": " + e.getMessage());
        }
    }
}