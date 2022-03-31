package com.github.stealthydron.example.steps;

import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class MainSteps {

    private final SubSteps subSteps;

    public MainSteps() {
        this.subSteps = new SubSteps();
    }

    @Step("Main Step 1")
    public void mainStep1() {
        System.out.println("main step");
    }

    @Step("Main Step 2 with sub steps")
    public void mainStep2() {
        System.out.println("Main Step 2 with sub steps");
        subSteps.subStep1();
        subSteps.subStep2();
    }

    @Step("Main Step 3 assert")
    public void assertThatSomething() {
        assertEquals(1, 2);
    }
}
