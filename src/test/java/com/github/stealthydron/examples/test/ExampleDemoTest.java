package com.github.stealthydron.examples.test;

import com.github.avpyanov.tools.annotations.AutotestId;
import com.github.stealthydron.example.steps.MainSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class ExampleDemoTest {

    private final MainSteps mainSteps = new MainSteps();

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Epic Feature")
    @Story("Create Work Item Demo Story")
    @TmsLink("14")
    @AutotestId("13")
    @Test(description = "Тест должен упасть java.lang.AssertionError, но перед этим сделать аттачмент")
    public void failedTestMethodExample() {
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Epic Feature")
    @Story("Create Work Item Demo Story")
    @TmsLink("12")
    @AutotestId("11")
    @Test(description = "Тест должен пройти")
    public void successfulTestMethodExample() {
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingPass();
    }
}
