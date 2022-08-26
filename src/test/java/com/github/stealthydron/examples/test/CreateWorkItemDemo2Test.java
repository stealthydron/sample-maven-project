package com.github.stealthydron.examples.test;

import com.github.avpyanov.testit.annotations.AutotestId;
import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.examples.TestngListener;
import com.github.stealthydron.examples.samples.TestSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.github.stealthydron.examples.app.StaticExample.doSomething;
import static com.github.stealthydron.examples.app.StaticExample.getSomething;
import static org.testng.Assert.assertEquals;

@Listeners({TestngListener.class})
public class CreateWorkItemDemo2Test {

    private final TestSteps steps = new TestSteps();
    private final MainSteps mainSteps = new MainSteps();

    @BeforeMethod
    public void setupMethod() {
        setup();
    }

    @AutotestId("35")
    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Epic Feature")
    @Story("Create Work Item Demo Story")
    @Test(description = "Test should fail on setup")
    public void testMethodExample5() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Step("setup")
    public void setup(){
        assertEquals(2, 1);
    }
}
