package com.github.stealthydrom.examples.test;

import com.github.stealthydrom.examples.samples.TestSteps;
import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.example.testit.annotation.AutotestId;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.stealthydrom.examples.app.StaticExample.doSomething;
import static com.github.stealthydrom.examples.app.StaticExample.getSomething;

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
    @Test(description = "TestWithBeforeAndAfter Name")
    @TmsLink("236")
    public void testMethodExample5() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomething();
    }

    @Step("Before class setup")
    private void beforeClassSetUp() {
        System.out.println("Before class setup");
    }

    @Step("Before method step")
    private void beforeMethodStep() {
        System.out.println("before method");
    }

}
