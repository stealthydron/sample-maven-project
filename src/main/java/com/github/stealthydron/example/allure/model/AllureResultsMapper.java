package com.github.stealthydron.example.allure.model;

import com.github.stealthydron.example.testit.TestItSettings;
import com.github.stealthydron.example.testit.client.TestItApi;
import com.github.stealthydron.example.testit.client.dto.Attachment;
import com.github.stealthydron.example.testit.client.dto.AutotestResults;
import com.github.stealthydron.example.testit.client.dto.AutotestResultsStep;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AllureResultsMapper {

    private static final String ALLURE_RESULTS_DIRECTORY = "target/allure-results/%s";

    private static final TestItSettings testItSettings = ConfigFactory.create(TestItSettings.class);

    private static final TestItApi testItApi = new TestItApi(testItSettings.endpoint(), testItSettings.token());


    public static AutotestResults mapToTestItResults(AllureResultsContainer allureResultsContainer) {
        final AutotestResults testItAutotest = new AutotestResults();

        testItAutotest.setOutcome(StringUtils.capitalize(allureResultsContainer.getStatus()));
        testItAutotest.setStartedOn(convertTimestampToDate(allureResultsContainer.getStart()));
        testItAutotest.setCompletedOn(convertTimestampToDate(allureResultsContainer.getStop()));


        if (!allureResultsContainer.getStatus().equals("Passed")) {
            testItAutotest.setMessage(allureResultsContainer.getStatusDetails().getMessage());
            testItAutotest.setTraces(allureResultsContainer.getStatusDetails().getTrace());
        }

        List<AutotestResultsStep> autotestResultsSteps = new ArrayList<>();
        List<AllureResultsStep> flattenAllureSteps = flattenSteps(allureResultsContainer.getSteps());

        for (AllureResultsStep flattenAllureStep : flattenAllureSteps) {
            AutotestResultsStep autotestResultsStep = new AutotestResultsStep();
            autotestResultsStep.setTitle(flattenAllureStep.getName());
            autotestResultsStep.setOutcome(StringUtils.capitalize(flattenAllureStep.getStatus()));
            autotestResultsStep.setStartedOn(convertTimestampToDate(flattenAllureStep.getStart()));
            autotestResultsStep.setCompletedOn(convertTimestampToDate(flattenAllureStep.getStop()));

            long duration = TimeUnit.MILLISECONDS.convert(flattenAllureStep.getStop() - flattenAllureStep.getStart(), TimeUnit.MILLISECONDS);
            autotestResultsStep.setDuration(duration);

            if (!flattenAllureStep.getParameters().isEmpty()) {
                Map<String, String> parametersMap = flattenAllureStep.getParameters()
                        .stream()
                        .collect(Collectors.toMap(Parameter::getName, Parameter::getValue));
                autotestResultsStep.setParameters(parametersMap);
            }

            if (!flattenAllureStep.getAttachments().isEmpty()) {
                List<Attachment> testItAttachments = new ArrayList<>();
                for (AllureAttachment attachment : flattenAllureStep.getAttachments()) {
                    String filePath = String.format(ALLURE_RESULTS_DIRECTORY, attachment.getSource());
                    Attachment testItAttachment = testItApi.getAttachmentsClient().createAttachment(new File(filePath));
                    testItAttachments.add(testItAttachment);
                }
                autotestResultsStep.setAttachments(testItAttachments);
            }

            autotestResultsSteps.add(autotestResultsStep);
        }

        testItAutotest.setStepResults(autotestResultsSteps);

        return testItAutotest;
    }


    private static String convertTimestampToDate(Long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(timestamp);
    }

    private static List<AllureResultsStep> flattenSteps(final List<AllureResultsStep> steps) {
        final List<AllureResultsStep> flattenSteps = new ArrayList<>();
        for (AllureResultsStep step : steps) {
            if (step.getSteps().isEmpty()) {
                flattenSteps.add(step);
            } else {
                flattenSteps.add(step);
                flattenSteps.addAll(flattenSteps(step.getSteps()));
            }
        }
        return flattenSteps;
    }
}
