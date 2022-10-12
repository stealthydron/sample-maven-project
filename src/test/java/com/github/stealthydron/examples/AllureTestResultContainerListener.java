package com.github.stealthydron.examples;

import io.qameta.allure.listener.ContainerLifecycleListener;
import io.qameta.allure.model.TestResultContainer;

public class AllureTestResultContainerListener implements ContainerLifecycleListener {

    public void afterContainerWrite(TestResultContainer container) {
        System.out.println("afterContainerWrite");
    }

    public void afterContainerStop(TestResultContainer container) {
        System.out.println("afterContainerStop");
    }

}
