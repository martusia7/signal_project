package com.alerts.decorators;

import com.alerts.Alert;

public abstract class AlertDecorator extends Alert{
    protected Alert decoratedAlert;

    public AlertDecorator(Alert decoratedAlert) {
        super(decoratedAlert.getPatientId(), decoratedAlert.getCondition(), decoratedAlert.getTimestamp());
        this.decoratedAlert = decoratedAlert;
    }

    @Override
    public void notifyAlert() {
        decoratedAlert.notifyAlert();
    }
}
