package com.github.stealthydron.examples;

import com.github.avpyanov.connector.testit.TestItSettings;
import com.github.avpyanov.testit.client.TestItApi;
import com.github.avpyanov.testit.client.dto.AutotestResults;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Link;
import io.qameta.allure.model.TestResult;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.model.Status.PASSED;

public class AllureLifecycleListener implements TestLifecycleListener {

    private static final Logger logger = LogManager.getLogger(AllureLifecycleListener.class);

    private final TestItSettings testItSettings = ConfigFactory.create(TestItSettings.class);
    private final TestItApi testItApi = new TestItApi(testItSettings.endpoint(), testItSettings.token());
    private final AllureResultsMapper allureResultsMapper = new AllureResultsMapper(testItApi, "target/allure-results/%s");

    @Override
    public void beforeTestStop(TestResult result) {
        if (!result.getStatus().equals(PASSED)) {
            Allure.addAttachment("Failed attach for " + result.getName(), "Failed attach for " + result.getName());
        }
    }


    @Override
    public void afterTestStop(TestResult result) {
        if (testItSettings.testRunId() != null) {
            final String testCaseId = getTestId(result, "tms");
            if (!testCaseId.isEmpty()) {
                String configurationId = testItApi.getTestRunsClient().getTestRun(testItSettings.testRunId())
                        .getTestResults()
                        .get(0)
                        .getConfigurationId();

                List<AutotestResults> autotestResultsList = new ArrayList<>();
                AutotestResults autotestResults = allureResultsMapper.mapAllureResults(result);
                autotestResults.setConfigurationId(configurationId);
                String externalId = testItApi.getAutotestsClient().getAutoTest(testCaseId).getExternalId();
                autotestResults.setAutoTestExternalId(externalId);
                autotestResultsList.add(autotestResults);
                try {
                    logger.info("Загрузка результатов тест-рана {}", autotestResultsList);
                    testItApi.getTestRunsClient().setAutoTestsResults(testItSettings.testRunId(), autotestResultsList);
                } catch (RuntimeException e) {
                    logger.error("Не удалось загрузить результаты тест-рана: {}", e.getMessage());
                }

            } else {
                logger.error("Не указана аннотация @AutotestId для {}", result.getFullName());
            }
        }
    }

    private String getTestId(TestResult result, String type) {
        Link link = result.getLinks()
                .stream()
                .filter(l -> l.getType().equals(type))
                .findFirst()
                .orElse(null);

        if (link != null) {
            return link.getName();
        } else return "";
    }
}
