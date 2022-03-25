package com.github.stealthydron.example.testit.client;

import com.github.stealthydron.example.testit.client.dto.*;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface TestItClient {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/v2/workItems")
    WorkItem createWorkItem(WorkItem testItTestCase);

    @RequestLine("GET /api/v2/workItems/{testCaseId}")
    WorkItem getWorkItem(@Param("testCaseId") String testCaseId);

    @Headers("Content-Type: application/json")
    @RequestLine("PUT /api/v2/workItems")
    WorkItem updateWorkItem(WorkItem testItTestCase);

    @RequestLine("GET /api/v2/projects/{projectId}")
    TestItProject getProject(@Param("projectId") String projectId);

    @RequestLine("GET /api/v2/projects/{projectId}/attributes")
    List<Attribute> getAttributes(@Param("projectId") String projectId);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/v2/projects/{projectId}/attributes")
    Attribute createAttribute(@Param("projectId") String projectId, Attribute attribute);

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/projects/{projectId}/sections?SearchField={fieldName}&SearchValue={value}")
    List<Section> findSection(@Param("projectId") String projectId,
                              @Param("fieldName") String fieldName,
                              @Param("value") String value);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/v2/sections")
    Section createSection(Section section);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/v2/autoTests")
    Autotest createAutotest(Autotest autotest);


    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testPlans/{testPlanId}/testSuites")
    List<TestSuite> getTestSuitesFromTestPlan(@Param("testPlanId") String testPlanId);


    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testSuites/{testSuiteId}/workItems")
    List<WorkItem> getWorkItemsFromSuite(@Param("testSuiteId") String testSuiteId);
}