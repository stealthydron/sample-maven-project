package com.github.stealthydron.examples;

import com.github.avpyanov.connector.testit.TestItSettings;
import com.github.avpyanov.testit.client.TestItApiClient;
import com.github.avpyanov.testit.client.dto.AutotestResults;
import com.github.avpyanov.testit.client.dto.AutotestResultsStep;
import com.github.avpyanov.tools.AllureConfig;
import com.github.avpyanov.tools.AllureResultsUtils;
import com.github.avpyanov.tools.TestFixtures;
import com.github.avpyanov.tools.TestRunUtils;
import com.google.gson.Gson;
import io.qameta.allure.listener.ContainerLifecycleListener;
import io.qameta.allure.listener.FixtureLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Label;
import io.qameta.allure.model.TestResult;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.github.avpyanov.tools.AllureUtils.getTestId;

public class AllureLifecycleListener implements TestLifecycleListener, FixtureLifecycleListener, ContainerLifecycleListener {

    private static final Logger logger = LogManager.getLogger(AllureLifecycleListener.class);
    private final TestItSettings testItSettings = ConfigFactory.create(TestItSettings.class);
    TestItApiClient testItApiClient = new TestItApiClient(testItSettings.endpoint(), testItSettings.token());

    public void afterTestWrite(TestResult result) {
        AllureConfig.setTestItApiClient(testItApiClient);
        AllureConfig.setAllureFolder("target/allure-results");
        AllureConfig.setAllureResultsPattern("target/allure-results/%s");

        if (testItSettings.testRunId() != null) {
            final String testCaseId = getTestId(result, "autotest");
            if (!testCaseId.isEmpty()) {

                String className = getClassName(result);
                String configurationId = TestRunUtils.getConfigurationId(testItSettings.testRunId());
                List<AutotestResults> autotestResultsList = new ArrayList<>();
                AutotestResults resultsFromAllure = AllureResultsUtils.getResultsFromAllure(result);
                resultsFromAllure.configurationId(configurationId);
                resultsFromAllure.autoTestExternalId(result.getFullName());
                autotestResultsList.add(resultsFromAllure);
                List<AutotestResultsStep> fixtures = TestFixtures.getFixtures(className);

                resultsFromAllure.setupResults(fixtures);

                System.out.println(new Gson().toJson(resultsFromAllure));
                try {
                    logger.info("Загрузка результатов тест-рана {}", autotestResultsList);
                    TestRunUtils.uploadTestResults(testItSettings.testRunId(), autotestResultsList);
                } catch (RuntimeException e) {
                    logger.error("Не удалось загрузить результаты тест-рана: {}", e.getMessage());
                }
            } else {
                logger.warn("Не указана аннотация @AutotestId для {}", result.getFullName());
            }
        }
    }

    public static String getClassName(TestResult result) {
        Label label = result.getLabels()
                .stream()
                .filter(l -> l.getName().equals("testClass"))
                .findFirst()
                .orElse(null);

        if (label != null) {
            return label.getValue();
        } else return "";
    }
}
