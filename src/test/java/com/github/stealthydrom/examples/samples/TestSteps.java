package com.github.stealthydrom.examples.samples;

import io.qameta.allure.Step;

public class TestSteps {

    @Step("Test step 1")
    public TestSteps testStep1() {
        System.out.println("Test step 1");
        return this;
    }

    @Step("Test step 2")
    public TestSteps testStep2() {
        System.out.println("Test step 2");
        substep();
        return this;
    }


    @Step("step2 substep")
    private void substep() {
        System.out.println("test2 substep");
    }
}