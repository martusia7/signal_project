package com.alerts.decorators;

import com.alerts.Alert;

public class PriorityAlertDecorator extends AlertDecorator {
    public PriorityAlertDecorator(Alert decoratedAlert) {
        super(decoratedAlert);
    }

    @Override
    public void notifyAlert() {
        decoratedAlert.notifyAlert();
        System.out.println("This is a high priority alert.");
    }
}
