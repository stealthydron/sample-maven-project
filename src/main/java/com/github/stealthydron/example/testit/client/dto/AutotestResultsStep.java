package com.github.stealthydron.example.testit.client.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AutotestResultsStep {
    private String title;
    private String description;
    private String startedOn;
    private String completedOn;
    private Integer duration;
    private String outcome;
    private List<Attachment> attachments;
    private List<Parameter> parameters;

    public AutotestResultsStep() {
        this.attachments = new ArrayList<>();
        this.parameters = new ArrayList<>();
    }
}