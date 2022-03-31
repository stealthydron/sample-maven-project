package com.github.stealthydron.example.testit;


import com.github.stealthydron.example.testit.client.TestItClient;
import com.github.stealthydron.example.testit.client.TestItClientBuilder;
import com.github.stealthydron.example.testit.client.dto.TestSuite;
import com.github.stealthydron.example.testit.client.dto.WorkItem;
import io.qameta.allure.TmsLink;
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

        final List<TestSuite> testSuites = testItClient.getTestSuitesFromTestPlan(testItSettings.testPlanId());

        final List<String> suiteIdList = new ArrayList<>();
        testSuites.forEach(testSuite -> {
            suiteIdList.add(testSuite.getId());
            if (!testSuite.getChildren().isEmpty()) {
                testSuite.getChildren().forEach(c -> suiteIdList.add(c.getId()));
            }
        });

        for (String s : suiteIdList) {
            List<WorkItem> workItemList = testItClient.getWorkItemsFromSuite(s);
            workItemList.forEach(workItem -> testIds.add(workItem.getGlobalId()));
        }

        return testIds;
    }

    private String getTestId(IMethodInstance instance) {
        return instance.getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(TmsLink.class)
                .value();
    }
}