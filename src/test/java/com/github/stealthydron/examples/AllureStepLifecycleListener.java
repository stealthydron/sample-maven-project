package com.github.stealthydron.examples;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;

public class AllureStepLifecycleListener implements StepLifecycleListener {

    public void beforeStepStop(StepResult result) {
        System.out.println("result.getStatus().value()="+result.getStatus().value());
        System.out.println("Start:"+result.getName());
    }
    public void afterStepStop(StepResult result) {
        System.out.println("Stop:"+result.getName());
    }
}