package com.alerts;
import java.util.ArrayList;
import java.util.List;

public class AlertManager {
    private List<Alert> alertLog;

    public AlertManager() {
        this.alertLog = new ArrayList<>();
    }

    public void dispatchAlert(Alert alert) {
        alertLog.add(alert);
        notifyStaff(alert);
    }

    private void notifyStaff(Alert alert) {
        System.out.println("ALERT:\n" + "Patient ID:" + alert.getPatientId() + "\nCondition:" + alert.getCondition() + "\nTimestamp:" + alert.getTimestamp());
    }

    public List<Alert> getAlertLog() {
        return new ArrayList<>(alertLog);
    }
}
