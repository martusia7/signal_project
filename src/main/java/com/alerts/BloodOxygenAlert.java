package com.alerts;

public class BloodOxygenAlert extends Alert {
    public BloodOxygenAlert(int patientId, String condition, long timestamp) {
        super(patientId, condition, timestamp);
    }

    @Override
    public void notifyAlert() {
        System.out.println("Blood Oxygen Alert for " + patientId + ": " + condition);
    }
}
