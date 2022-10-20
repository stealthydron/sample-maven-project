package com.github.stealthydron.examples.test;

import com.github.stealthydron.example.steps.MainSteps;
import com.github.stealthydron.examples.samples.TestSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.russianpost.portal.tools.annotations.AutotestId;

import static com.github.stealthydron.examples.app.StaticExample.doSomething;
import static com.github.stealthydron.examples.app.StaticExample.getSomething;

public class CreateWorkItemDemo2Test {

    private final TestSteps steps = new TestSteps();
    private final MainSteps mainSteps = new MainSteps();


    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Epic Feature")
    @Story("Create Work Item Demo Story")
    @TmsLink("15")
    @AutotestId("14")
    @Test
    @DisplayName("reate Work Item Demo name")
    public void testMethodExample5() {
        String text = getSomething();
        doSomething(text);
        steps.testStep1().testStep2();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.assertThatSomethingFail();
    }
}
