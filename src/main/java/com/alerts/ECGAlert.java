package com.alerts;

public class ECGAlert extends Alert {
    public ECGAlert(int patientId, String condition, long timestamp) {
        super(patientId, condition, timestamp);
    }

    @Override
    public void notifyAlert() {
        System.out.println("ECG Alert for " + patientId + ": " + condition);
    }
}
