package com.alerts.decorators;

import com.alerts.Alert;

public class RepeatedAlertDecorator extends AlertDecorator{
    public RepeatedAlertDecorator(Alert decoratedAlert) {
        super(decoratedAlert);
    }

    @Override
    public void notifyAlert() {
        decoratedAlert.notifyAlert();
        System.out.println("This alert will be repeated.");
    }
}
