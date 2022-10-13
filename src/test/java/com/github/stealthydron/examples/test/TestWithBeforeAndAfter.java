package com.github.stealthydron.examples.test;

import com.github.avpyanov.tools.annotations.AutotestId;
import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.examples.samples.TestSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.stealthydron.examples.app.StaticExample.doSomething;
import static com.github.stealthydron.examples.app.StaticExample.getSomething;

public class TestWithBeforeAndAfter {

    private final TestSteps steps = new TestSteps();
    private final MainSteps mainSteps = new MainSteps();

    @BeforeClass
    public void classSetUp() {
        beforeClassSetUp();
    }

    @BeforeMethod
    public void methodSetup() {
        beforeMethodStep();
    }

    @Epic("TestWithBeforeAndAfter epic")
    @Feature("TestWithBeforeAndAfter feature")
    @Story("TestWithBeforeAndAfter story")
    @TmsLink("10")
    @AutotestId("9")
    @Test(description = "TestWithBeforeAndAfter Name")
    public void testMethodExample5() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("TestWithBeforeAndAfter epic")
    @Feature("TestWithBeforeAndAfter feature")
    @Story("TestWithBeforeAndAfter story")
    @TmsLink("8")
    @AutotestId("7")
    @Test(description = "TestWithBeforeAndAfter Name")
    public void testMethodExample6() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("TestWithBeforeAndAfter epic")
    @Feature("TestWithBeforeAndAfter feature")
    @Story("TestWithBeforeAndAfter story")
    @TmsLink("12")
    @AutotestId("11")
    @Test(description = "TestWithBeforeAndAfter Name")
    public void testMethodExample7() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Step("Before class setup")
    private void beforeClassSetUp() {
        Allure.addAttachment("test", "Before class setup");
        System.out.println("Before class setup");
    }


    @Step("Before method step")
    private void beforeMethodStep() {
        Allure.addAttachment("test", "Before method step");
        System.out.println("before method");
    }

}
