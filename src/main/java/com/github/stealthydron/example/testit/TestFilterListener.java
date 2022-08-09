package com.github.stealthydron.example.testit;


import com.github.stealthydron.example.testit.annotation.AutotestId;
import com.github.stealthydron.example.testit.client.TestItClient;
import com.github.stealthydron.example.testit.client.TestItClientBuilder;
import com.github.stealthydron.example.testit.client.dto.TestResult;
import org.aeonbits.owner.ConfigFactory;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

public class TestFilterListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        final List<IMethodInstance> result = new ArrayList<>();
        final List<String> testIdList = getTesCases();

        for (IMethodInstance iMethodInstance : list) {
            String testId = getTestId(iMethodInstance);
            if (testIdList.contains(testId)) {
                result.add(iMethodInstance);
            }
        }
        return result;
    }

    private List<String> getTesCases() {
        final List<String> testIds = new ArrayList<>();
        final TestItSettings testItSettings = ConfigFactory.create(TestItSettings.class);

        final TestItClient testItClient = new TestItClientBuilder()
                .endpoint(testItSettings.endpoint())
                .token(testItSettings.token())
                .build();

        List<TestResult> results = testItClient.getTestRun(testItSettings.testRunId()).getTestResults();
        for (TestResult result : results) {
            testIds.add(result.getAutoTest().getGlobalId());
        }
        System.out.println("testIds: " + testIds);
        return testIds;
    }

    private String getTestId(IMethodInstance instance) {
        return instance.getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(AutotestId.class)
                .value();
    }
}