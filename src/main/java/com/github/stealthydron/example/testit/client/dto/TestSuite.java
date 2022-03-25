package com.github.stealthydron.example.testit.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TestSuite {

    private String id;
    private String name;
    private String testPlanId;
    private List<TestSuite> children;
}
