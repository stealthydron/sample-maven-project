package com.github.stealthydron.example.testit.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestRun {

  private String id;
  private String name;
  private String description;
  private String projectId;
  private String testPlanId;
  private List<TestResult> testResults;

}
