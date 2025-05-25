package com.alerts.strategies;

import java.util.List;

import com.alerts.Alert;
import com.alerts.AlertFactory;
import com.data_management.Patient;
import com.data_management.PatientRecord;

public class OxygenSaturationStrategy implements AlertStrategy {
    private AlertFactory alertFactory;

    public OxygenSaturationStrategy(AlertFactory alertFactory) {
        this.alertFactory = alertFactory;
    }

    @Override
    public void checkAlert(Patient patient) {
        long currentTime = System.currentTimeMillis();
        long oneDayMillis = 24 * 60 * 60 * 1000;
        List<PatientRecord> records = patient.getRecords(currentTime - oneDayMillis, currentTime);

        for (PatientRecord record : records) {
            if ("OxygenSaturation".equals(record.getRecordType())) {
                double value = record.getMeasurementValue();
                if (value < 92) {
                    Alert alert = alertFactory.createAlert(patient.getId(), "Low Blood Oxygen", record.getTimestamp());
                    alert.notifyAlert();
                }
            }
        }
    }
}
