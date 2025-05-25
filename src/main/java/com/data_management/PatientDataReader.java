package com.data_management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PatientDataReader implements DataReader {

    private String filePath;

    public PatientDataReader (String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void readData(DataStorage dataStorage) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int patientId = Integer.parseInt(parts[0]);
            double measurementValue = Double.parseDouble(parts[1]);
            String recordType = parts[2];
            long timestamp = Long.parseLong(parts[3]);
            dataStorage.addPatientData(patientId, measurementValue, recordType, timestamp);
        }
        reader.close();
    }
    
    @Override
    public void connectWebSocket(String url, DataStorage dataStorage) throws IOException {
        // try {
        //     URI uri = new URI(url);
        //     WebSocketClientImpl client = new WebSocketClientImpl(uri, dataStorage);
        //     client.connectBlocking(); // Blocking connect to ensure connection is established
        // } catch (URISyntaxException | InterruptedException e) {
        //     // Handle connection errors
        //     throw new IOException("Failed to connect to WebSocket", e);
        // }
    }
    
}
