package com.github.stealthydron.examples.test;

import com.github.avpyanov.testit.annotations.AutotestId;
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
    @AutotestId("108")
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
    @AutotestId("106")
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
    @AutotestId("102")
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
    @AutotestId("104")
    public void testMethodExample11() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }


    @Feature("Create Work Item Demo Feature")
    @Story("Create Work Item Demo Story")
    @Test(description = "Create Work Item Demo Test12 Name")
    @AutotestId("115")
    public void testMethodExample12() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Feature")
    @TmsLink("202")
    @AutotestId("201")
    @Test(description = "Create Work Item Demo Test13 Name")
    public void testMethodExample13() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }
}