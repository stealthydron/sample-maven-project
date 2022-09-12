package com.github.stealthydron.examples.test;

import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.examples.samples.TestSteps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.github.stealthydron.examples.app.StaticExample.doSomething;
import static com.github.stealthydron.examples.app.StaticExample.getSomething;

public class CreateWorkItemDemoTest {

    private final TestSteps steps = new TestSteps();
    private final MainSteps mainSteps = new MainSteps();

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Feature")
    @Story("Create Work Item Demo Story")
    @Test(description = "Create Work Item Demo Test Name")
    @TmsLink("73")
    public void testMethodExample5() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Feature")
    @Story("Create Work Item Demo Story")
    @Test(description = "Create Work Item Demo Test6 Name")
    @TmsLink("71")
    public void testMethodExample6() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Feature")
    @Story("Create Work Item Demo Story")
    @Test(description = "Create Work Item Demo Test10 Name")
    @TmsLink("67")
    public void testMethodExample10() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Feature")
    @Story("Create Work Item Demo Story")
    @Test(description = "Create Work Item Demo Test11 Name")
    @TmsLink("69")
    public void testMethodExample11() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }
}