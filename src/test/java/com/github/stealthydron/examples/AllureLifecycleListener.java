package com.github.stealthydron.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

import static io.qameta.allure.model.Status.FAILED;

public class AllureLifecycleListener implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus().equals(FAILED)) {
            Allure.addAttachment("Failed attach for " + result.getName(), "Failed attach for " + result.getName());
        }

    }
}
