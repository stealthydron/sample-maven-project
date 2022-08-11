package com.github.stealthydron.example.testit.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class AutotestPutRequestDto {

    private String id;
    private String externalId;
    private String globalId;
    private String projectId;
    private String name;
    private String namespace;
    private String classname;
    private String title;
    private String description;
    private List<AutotestStep> steps;
    private List<AutotestStep> setup;
    private List<AutotestStep> teardown;
    private List<Link> links;
    private List<String> workItemIdsForLinkWithAutoTest;
    private boolean isFlaky;
}