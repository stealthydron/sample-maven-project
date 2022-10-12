package com.github.stealthydron.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;

public class AllureStepLifecycleListener implements StepLifecycleListener {

    public void beforeStepStop(StepResult result) {
      if(result.getStatus()!= Status.PASSED){
          Allure.addAttachment(result.getName(),"beforeStepStop");
      }
    }
    public void afterStepStop(StepResult result) {
        if(result.getStatus()!= Status.PASSED){
            Allure.addAttachment(result.getName(),"afterStepStop");
        }
    }

    public void beforeStepUpdate(StepResult result) {
        if(result.getStatus()!= Status.PASSED){
            Allure.addAttachment(result.getName(),"beforeStepUpdate");
        }
    }
}