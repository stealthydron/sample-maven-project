package com.github.stealthydron.examples.test;

import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.examples.samples.TestSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
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
    @Feature("TestWithBeforeAndAfter testMethodExample6")
    @Story("TestWithBeforeAndAfter testMethodExample6")
    @Test(description = "TestWithBeforeAndAfter testMethodExample6")
    @Tags({@Tag("smoke")})
    public void testMethodExample6() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("TestWithBeforeAndAfter epic")
    @Feature("TestWithBeforeAndAfter testMethodExample7")
    @Story("TestWithBeforeAndAfter testMethodExample7")
    @Test(description = "TestWithBeforeAndAfter testMethodExample7")
    public void testMethodExample7() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingPass();
    }

    @Epic("TestWithBeforeAndAfter epic")
    @Feature("TestWithBeforeAndAfter testMethodExample11")
    @Story("TestWithBeforeAndAfter testMethodExample11")
    @Test(description = "TestWithBeforeAndAfter testMethodExample11")
    public void testMethodExample11() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("TestWithBeforeAndAfter epic")
    @Feature("TestWithBeforeAndAfter testMethodExample14")
    @Story("TestWithBeforeAndAfter testMethodExample14")
    @Test(description = "TestWithBeforeAndAfter testMethodExample14")
    public void testMethodExample14() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingPass();
    }


    @Epic("TestWithBeforeAndAfter epic")
    @Feature("TestWithBeforeAndAfter testMethodExample19")
    @Story("TestWithBeforeAndAfter testMethodExample19")
    @Test(description = "TestWithBeforeAndAfter testMethodExample19")
    public void testMethodExample19() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingPass();
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
