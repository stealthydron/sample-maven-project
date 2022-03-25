package com.github.stealthydron.example.testit.client.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class WorkItem {

    private String globalId;
    private String name;
    private String description;
    private String projectId;
    private String sectionId;
    private String entityTypeName;
    private String state;
    private String priority;
    private List<WorkItemTestStep> steps;
    private List<WorkItemTestStep> preconditionSteps;
    private List<WorkItemTestStep> postconditionSteps;
    private int duration;
    private Map<String, String> attributes;
    private List<Tag> tags;
    private List<Link> links;
    private List<Autotest> autoTests;

    public WorkItem() {
        this.steps = new ArrayList<>();
        this.preconditionSteps = new ArrayList<>();
        this.postconditionSteps = new ArrayList<>();
        this.duration = 300;
        this.attributes = new HashMap<>();
        this.tags = new ArrayList<>();
        this.links = new ArrayList<>();
    }
}
