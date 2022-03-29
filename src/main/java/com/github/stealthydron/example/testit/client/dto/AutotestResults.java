package com.github.stealthydron.example.testit.client.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private List<Parameter> parameters;
    private List<Property> properties;
    private List<AutotestResultsStep> stepResults;
    private List<AutotestResultsStep> setupResults;
    private List<AutotestResultsStep> teardownResults;

    public AutotestResults() {
        this.attachments = new ArrayList<>();
        this.parameters = new ArrayList<>();
        this.properties = new ArrayList<>();
        this.stepResults = new ArrayList<>();
        this.setupResults = new ArrayList<>();
        this.teardownResults = new ArrayList<>();
    }
}
