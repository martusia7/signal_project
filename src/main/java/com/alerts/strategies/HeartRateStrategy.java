package com.alerts.strategies;

import java.util.List;

import com.alerts.Alert;
import com.alerts.AlertFactory;
import com.data_management.Patient;
import com.data_management.PatientRecord;

public class HeartRateStrategy implements AlertStrategy{
    private AlertFactory alertFactory;

    public HeartRateStrategy(AlertFactory alertFactory) {
        this.alertFactory = alertFactory;
    }

    @Override
    public void checkAlert(Patient patient) {
        long currentTime = System.currentTimeMillis();
        long oneDayMillis = 24 * 60 * 60 * 1000;
        List<PatientRecord> records = patient.getRecords(currentTime - oneDayMillis, currentTime);

        for (PatientRecord record : records) {
            if ("HeartRate".equals(record.getRecordType())) {
                double value = record.getMeasurementValue();
                if (value < 50 || value > 100) {
                    Alert alert = alertFactory.createAlert(patient.getId(), "Abnormal Heart Rate", record.getTimestamp());
                    alert.notifyAlert();
                }
            }
        }
    }
    
}
