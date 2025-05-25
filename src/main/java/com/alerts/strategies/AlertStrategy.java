package com.alerts.strategies;

import com.data_management.Patient;

public interface AlertStrategy {
    void checkAlert(Patient patient);
}
