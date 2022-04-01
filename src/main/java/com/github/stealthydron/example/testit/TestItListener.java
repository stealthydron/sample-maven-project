package com.github.stealthydron.example.testit;

import com.github.stealthydron.example.allure.model.AllureResultsContainer;
import com.github.stealthydron.example.allure.model.AllureResultsMapper;
import com.github.stealthydron.example.allure.model.Link;
import com.github.stealthydron.example.testit.client.TestItClient;
import com.github.stealthydron.example.testit.client.TestItClientBuilder;
import com.github.stealthydron.example.testit.client.dto.AutotestResults;
import com.github.stealthydron.example.testit.client.dto.WorkItem;
import com.google.gson.Gson;
import io.qameta.allure.TmsLink;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestItListener extends TestListenerAdapter {

    private static final Logger logger = LogManager.getLogger(TestItListener.class);

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
        final String allureResultsDirectory = "target/allure-results";
        File[] files = new File(allureResultsDirectory).listFiles();
        if (files == null) {
            logger.error("Не удалось получить файлы из директории " + allureResultsDirectory);
        } else {
            List<String> testResults = getAllureResults(files);
            List<AutotestResults> autotestResultsList = new ArrayList<>();
            for (String testResult : testResults) {
                AllureResultsContainer result = getResultsFromFile(testResult);

                if (result == null) {
                    logger.error("Не удалось получить результаты для " + testResult);
                } else {

                    final String testCaseId = getTestId(result);

                    if (testCaseId.isEmpty()) {
                        logger.error("Не указана аннотация @TmsLink для " + result.getFullName());
                    } else {
                        AutotestResults autotestResults = AllureResultsMapper.mapToTestItResults(result);
                        autotestResults.setConfigurationId(testItSettings.configurationId());
                        String externalId = testItClient.getWorkItem(testCaseId).getAutoTests().get(0).getExternalId();
                        autotestResults.setAutoTestExternalId(externalId);
                        autotestResultsList.add(autotestResults);
                    }
                }
            }
            System.out.println(autotestResultsList);
            testItClient.setAutoTestsResults(testItSettings.testRunId(), autotestResultsList);
        }
        //testItClient.completeTestRun(testItSettings.testRunId());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testId = getTestId(result);
        String autotestExternalId = testItClient.getWorkItem(testId).getAutoTests().get(0).getExternalId();
        AutotestResults results = new AutotestResults();
        results.setAutoTestExternalId(autotestExternalId);
        results.setOutcome("Passed");
        results.setConfigurationId(testItSettings.configurationId());
        testItClient.setAutoTestsResults(testItSettings.testRunId(), Collections.singletonList(results));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testId = getTestId(result);
        String autotestExternalId = testItClient.getWorkItem(testId).getAutoTests().get(0).getExternalId();
        AutotestResults results = new AutotestResults();
        results.setAutoTestExternalId(autotestExternalId);
        results.setOutcome("Failed");
        results.setConfigurationId(testItSettings.configurationId());
        testItClient.setAutoTestsResults(testItSettings.testRunId(), Collections.singletonList(results));
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

    private String getTestId(AllureResultsContainer resultsContainer) {
        Link tms = resultsContainer.getLinks()
                .stream()
                .filter(link -> link.getType().equals("tms"))
                .findFirst()
                .orElse(null);
        if (tms != null) {
            return tms.getName();
        } else return "";
    }

    private AllureResultsContainer getResultsFromFile(final String fileName) {
        final String filePath = String.format("target/allure-results/%s", fileName);
        try {
            return new Gson().fromJson(new FileReader(filePath), AllureResultsContainer.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> getAllureResults(File[] files) {
        return Stream.of(files)
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .filter(name -> name.contains("result"))
                .collect(Collectors.toList());
    }
}