package com.github.stealthydron.example.testit.client.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AutotestResults {

    private String configurationId;
    private String autoTestExternalId;
    private String outcome;
    private String message;
    private String traces;
    private String startedOn;
    private String completedOn;
    private Integer duration;
    private List<Attachment> attachments;
    private Map<String, String> parameters;
    private Map<String, String>  properties;
    private List<AutotestResultsStep> stepResults;
    private List<AutotestResultsStep> setupResults;
    private List<AutotestResultsStep> teardownResults;

    public AutotestResults() {
        this.attachments = new ArrayList<>();
        this.parameters = new HashMap<>();
        this.properties = new HashMap<>();
        this.stepResults = new ArrayList<>();
        this.setupResults = new ArrayList<>();
        this.teardownResults = new ArrayList<>();
    }
}
