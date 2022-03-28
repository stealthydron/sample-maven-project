package com.github.stealthydron.example.testit;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestItListener extends TestListenerAdapter {

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName());
        System.out.println(result.getStatus());
        System.out.println(result.getTestContext().getStartDate());
        System.out.println(result.getTestContext().getEndDate());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }
}
