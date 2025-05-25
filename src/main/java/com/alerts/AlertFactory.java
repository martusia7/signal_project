package com.alerts;

public  class AlertFactory {

    public  Alert createAlert(int patientId, String condition, long timestamp) {
        return new Alert(patientId, condition, timestamp); 
    }

}
