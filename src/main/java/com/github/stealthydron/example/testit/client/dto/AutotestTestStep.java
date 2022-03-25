package com.github.stealthydron.example.testit.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AutotestTestStep {

    private String title;
    private String description;

    public AutotestTestStep(String title) {
        this.title = title;
    }
}