package com.github.stealthydron.examples.test;

import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.examples.samples.TestSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import ru.russianpost.portal.tools.annotations.AutotestId;

import static com.github.stealthydron.examples.app.StaticExample.doSomething;
import static com.github.stealthydron.examples.app.StaticExample.getSomething;

public class CreateWorkItemDemoTest {

    private final TestSteps steps = new TestSteps();
    private final MainSteps mainSteps = new MainSteps();

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Feature")
    @Story("Create Work Item Demo Story")
    @TmsLink("21")
    @AutotestId("20")
    @Test(description = "Create Work Item Demo Test Name")
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
    @TmsLink("23")
    @AutotestId("22")
    @Test(description = "Create Work Item Demo Test6 Name")
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
    @TmsLink("27")
    @AutotestId("26")
    @Test(description = "Create Work Item Demo Test10 Name")
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
    @TmsLink("17")
    @AutotestId("16")
    @Test(description = "Create Work Item Demo Test11 Name")
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
    @TmsLink("25")
    @AutotestId("24")
    @Test(description = "Create Work Item Demo Test12 Name")
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
    @TmsLink("19")
    @AutotestId("18")
    @Test(description = "Create Work Item Demo Test13 Name")
    public void testMethodExample13() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingPass();
    }
}