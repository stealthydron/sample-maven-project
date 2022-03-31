package com.github.stealthydrom.examples.test;

import com.github.stealthydrom.examples.samples.TestSteps;
import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.example.testit.annotation.AutotestId;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.github.stealthydrom.examples.app.StaticExample.getSomething;
import static org.testng.Assert.assertEquals;

public class ExportTests {

    private final TestSteps steps = new TestSteps();
    private final MainSteps mainSteps = new MainSteps();

    @Epic("Test epic")
    @Feature("Test feature")
    @Story("Test story")
    @Test(description = "Test Name")
    @TmsLink("185")
    public void testMethodExample() {
        String text = getSomething();
        testStep(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
    }

    @Epic("Test epic")
    @Feature("Test feature 2")
    @Story("Test story 2")
    @Test(description = "Test Name 2")
    @TmsLink("206")
    public void testMethodExample2() {
        String text = getSomething();
        testStep(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
    }

    @Epic("Test epic")
    @Feature("Test feature 3")
    @Story("Test story 3")
    @Test(description = "Test Name 3")
    @TmsLink("208")
    public void testMethodExample3() {
        String text = getSomething();
        testStep2(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
    }

    @Epic("Test epic")
    @Feature("Test feature 4")
    @Story("Test story 4")
    @Test(description = "Test Name 4")
    @TmsLink("218")
    @AutotestId("217")
    public void testMethodExample4() {
        String text = getSomething();
        testStep2(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
    }

    @Epic("Test epic")
    @Feature("Test feature 5")
    @Story("Test story 5")
    @Test(description = "Test Name 5")
    @TmsLink("230")
    @AutotestId("229")
    public void testMethodExample5() {
        String text = getSomething();
        testStep2(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
    }


    @Step("Test step {text}")
    public void testStep(String text) {
        System.out.println(text);
    }

    @Step("Test step {text}")
    public void testStep2(String text) {
        Allure.addAttachment("Attachment","text/html","test test test");
        assertEquals(1, 2);
    }
}
