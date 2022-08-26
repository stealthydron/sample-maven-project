package com.github.stealthydron.examples;

import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngListener extends TestListenerAdapter implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult result) {
        if (iInvokedMethod.isConfigurationMethod() && result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("on test failure attachment", "on test failure attachment content");
        }

        if (!iInvokedMethod.isConfigurationMethod() && result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("on configuration failure attachment", "on configuration failure attachment content");
        }
    }
}