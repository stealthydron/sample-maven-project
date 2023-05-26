package com.github.stealthydron.examples.test;

import com.github.avpyanov.tools.annotations.AutotestId;
import com.github.stealthydron.example.dto.AddressDto;
import com.github.stealthydron.example.steps.MainSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;


public class ExceptionsDemoTest {

    private final MainSteps mainSteps = new MainSteps();

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Epic Feature")
    @Story("Create Work Item Demo Story")
    @TmsLink("30")
    @AutotestId("29")
    @Test(description = "Тест должен выбросить java.lang.NullPointerException")
    public void testMethodExample1() {
        AddressDto addressDto = new AddressDto();
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.fillSomething(addressDto);
    }

    @Epic("Create Work Item Demo Epic")
    @Feature("Create Work Item Demo Epic Feature")
    @Story("Create Work Item Demo Story")
    @TmsLink("32")
    @AutotestId("31")
    @Test(description = "Тест должен упасть java.lang.AssertionError")
    public void testMethodExample2() {
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet("Улица разбитых фонарей");
        mainSteps.mainStep1();
        mainSteps.mainStep2();
        mainSteps.fillSomething(addressDto);
    }
}
