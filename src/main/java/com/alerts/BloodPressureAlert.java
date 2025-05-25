package com.alerts;

public class BloodPressureAlert extends Alert {
    
    public BloodPressureAlert(int patientId, String condition, long timestamp) {
        super(patientId, condition, timestamp);
    }

    @Override
    public void notifyAlert() {
        System.out.println("Blood Pressure Alert for " + patientId + ": " + condition);
    }
}
