package com.github.stealthydrom.examples.test;

import com.github.stealthydrom.examples.samples.TestSteps;
import com.github.stealthydron.example.steps.MainSteps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.github.stealthydrom.examples.app.StaticExample.getSomething;

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

    @Step("Test step {text}")
    public void testStep(String text) {
        System.out.println(text);
    }
}
