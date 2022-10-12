package com.github.stealthydron.examples.test;

import com.github.avpyanov.connector.testit.TestItSettings;
import com.github.avpyanov.testit.client.TestItApiClient;
import com.github.avpyanov.tools.AllureConfig;
import com.github.avpyanov.tools.TestRunUtils;
import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

public class TestNGUploadResultsListener extends TestListenerAdapter {

    TestItSettings settings = ConfigFactory.create(TestItSettings.class);

    public void onFinish(ITestContext context) {
        TestItApiClient testItApiClient = new TestItApiClient(settings.endpoint(), settings.token());
        AllureConfig.setTestItApiClient(testItApiClient);
        AllureConfig.setAllureFolder("target/allure-results");
        AllureConfig.setAllureResultsPattern("target/allure-results/%s");
        if (settings.testRunId() != null) {
            TestRunUtils.uploadTestResultsFromAllureResultFiles(settings.testRunId());
        }
    }
}