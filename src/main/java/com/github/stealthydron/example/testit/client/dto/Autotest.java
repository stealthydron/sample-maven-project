package com.github.stealthydron.example.testit.client.dto;

import lombok.*;

import java.util.List;

@Data
public class Autotest {

    private String id;
    private String externalId;
    private String projectId;
    private String name;
    private String namespace;
    private String classname;
    private String title;
    private String description;
    private List<AutotestTestStep> steps;
}