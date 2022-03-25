package com.github.stealthydron.example.testit.client.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(fluent = true)
@ToString
public class WorkItemTestStep {

    private String id;
    private String action;
    private String expected;
    private String testData;
    private String comments;
    private String workItemId;
}
