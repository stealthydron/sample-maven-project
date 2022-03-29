package com.github.stealthydron.example.testit;

import com.github.stealthydron.example.testit.client.TestItClient;
import com.github.stealthydron.example.testit.client.TestItClientBuilder;
import com.github.stealthydron.example.testit.client.dto.WorkItem;
import io.qameta.allure.TmsLink;
import org.aeonbits.owner.ConfigFactory;
import org.testng.IMethodInstance;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestItListener extends TestListenerAdapter {

    private final TestItSettings testItSettings = ConfigFactory.create(TestItSettings.class);

    private final TestItClient testItClient = new TestItClientBuilder()
            .endpoint(testItSettings.endpoint())
            .token(testItSettings.token())
            .build();

    @Override
    public void onStart(ITestContext context) {
        testItClient.startTestPlan(testItSettings.testPlanId());
    }

    @Override
    public void onFinish(ITestContext context) {
        //ToDo взять результаты из allure-results и прокинуть в testIt
        testItClient.completeTestRun(testItSettings.testRunId());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //ToDo set auto-test results for test plan
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getThrowable().getMessage());
        //ToDo set auto-test results for test plan
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //ToDo set auto-test results for test plan
    }

    private WorkItem getWorkItemById(String testCaseId) {
        return testItClient.getWorkItem(testCaseId);
    }

    private String getTestId(ITestResult result) {
        return result.getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(TmsLink.class)
                .value();
    }
}