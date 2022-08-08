package com.github.stealthydron.example.testit.client;

import com.github.stealthydron.example.testit.client.dto.*;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.io.File;
import java.util.List;

public interface TestItClient {

    @RequestLine("GET /api/v2/workItems/{testCaseId}")
    WorkItem getWorkItem(@Param("testCaseId") String testCaseId);

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testPlans/{testPlanId}/testSuites")
    List<TestSuite> getTestSuitesFromTestPlan(@Param("testPlanId") String testPlanId);

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testSuites/{testSuiteId}/workItems")
    List<WorkItem> getWorkItemsFromSuite(@Param("testSuiteId") String testSuiteId);

    @RequestLine("POST /api/v2/testPlans/{testPlanId}/start")
    void startTestPlan(@Param("testPlanId") String testPlanId);

    @RequestLine("POST /api/v2/testRuns/{testRunId}/complete")
    void completeTestRun(@Param("testRunId") String testPlanId);

    @Headers("Content-Type: multipart/form-data")
    @RequestLine("POST /api/v2/attachments?apiVersion=2")
    Attachment createAttachment(@Param(value = "file") File attachment);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/v2/testRuns/{testRunId}/testResults")
    void setAutoTestsResults(@Param("testRunId") String testRunId, List<AutotestResults> autoTestsResults);

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testRuns/{testRunId}")
    List<AutotestResults> getTestRun(@Param(value = "testRunId") String testRunId);
}