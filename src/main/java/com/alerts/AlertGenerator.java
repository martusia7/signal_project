package com.alerts;

import com.data_management.DataStorage;
import com.data_management.Patient;

/**s
 * The {@code AlertGenerator} class is responsible for monitoring patient data
 * and generating alerts when certain predefined conditions are met. This class
 * relies on a {@link DataStorage} instance to access patient data and evaluate
 * it against specific health criteria.
 */
public class AlertGenerator {
    private DataStorage dataStorage;
    private AlertManager alertManager;

    private BloodPressureAlertFactory bpFactory = new BloodPressureAlertFactory();
    private BloodOxygenAlertFactory boFactory = new BloodOxygenAlertFactory();
    private ECGAlertFactory ecgFactory = new ECGAlertFactory();

    /**
     * Constructs an {@code AlertGenerator} with a specified {@code DataStorage}.
     * The {@code DataStorage} is used to retrieve patient data that this class
     * will monitor and evaluate.
     *
     * @param dataStorage the data storage system that provides access to patient
     *                    data
     */
    public AlertGenerator(DataStorage dataStorage, AlertManager alertManager) {
        this.dataStorage = dataStorage;
        this.alertManager = alertManager;
    }

    /**
     * Evaluates the specified patient's data to determine if any alert conditions
     * are met. If a condition is met, an alert is triggered via the
     * {@link #triggerAlert}
     * method. This method should define the specific conditions under which an
     * alert
     * will be triggered.
     *
     * @param patient the patient data to evaluate for alert conditions
     */
    public void evaluateData(Patient patient) {
        int heartRate = patient.getHeartRate();
        int patientId = patient.getId();
        long currentTime = System.currentTimeMillis();

        if (heartRate < 50) {
            triggerAlert(new Alert(patientId, "Heart rate too low" + heartRate + "bpm", currentTime));
        } else if (heartRate > 120) {
            triggerAlert(new Alert(patientId, "Heart rate too high" + heartRate + "bpm", currentTime));
        }
    }

    /**
     * Triggers an alert for the monitoring system. This method can be extended to
     * notify medical staff, log the alert, or perform other actions. The method
     * currently assumes that the alert information is fully formed when passed as
     * an argument.
     *
     * @param alert the alert object containing details about the alert condition
     */
    private void triggerAlert(Alert alert) {
        alertManager.dispatchAlert(alert);
    }
}
