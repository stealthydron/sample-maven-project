package com.github.stealthydron.examples;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import org.testng.IConfigurationListener;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngListener extends TestListenerAdapter implements IInvokedMethodListener, IConfigurationListener, TestLifecycleListener {


    @Override
    public void onConfigurationFailure(ITestResult tr) {
        Allure.addAttachment("on configuration failure attachment", "on configuration failure attachment content");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println(Allure.getLifecycle().getCurrentTestCaseOrStep());
        Allure.addAttachment("on test failure attachment", "on test failure attachment content");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
      // tr.setStatus(ITestResult.FAILURE);
    }


}