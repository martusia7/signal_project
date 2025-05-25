package com.alerts;

// Represents an alert
public class Alert {
    protected int patientId;
    protected String condition;
    protected long timestamp;

    public Alert(int patientId, String condition, long timestamp) {
        this.patientId = patientId;
        this.condition = condition;
        this.timestamp = timestamp;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getCondition() {
        return condition;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void notifyAlert() {
        System.out.println("Generic Alert: " + condition + " for patient " + patientId);
    }
}
