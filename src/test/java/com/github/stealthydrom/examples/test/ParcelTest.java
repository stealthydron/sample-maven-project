package com.github.stealthydrom.examples.test;

import com.github.stealthydrom.examples.app.Application;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class ParcelTest {

    private final Application app = new Application();

    @Epic("Посылки")
    @Feature("Оформление внутрироссийских посылок")
    @Story("Оформление посылки москва - спб 1 кг")
    @Test(description = "Для посылки москва - спб формируется бланк ...")
    @TmsLink("195")
    public void createParcelTest() {
        app.openParcelsPage()
                .fillSenderAddress("Москва Мофсфильмовская")
                .fillRecipientAddress("Спб")
                .fillWeight("1 кг")
                .checkOut()
                .fillSender()
                .fillRecipient();
    }

    @Epic("Посылки")
    @Feature("Оформление внутрироссийских посылок")
    @Story("Оформление посылки 1 класса")
    @Test(description = "Максимальный вес посылки 1 класса - 5 кг")
    @TmsLink("199")
    public void createFirstClassParcelTest() {
        app.openParcelsPage()
                .fillSenderAddress("Москва Мофсфильмовская")
                .fillRecipientAddress("Спб")
                .fillWeight("6 кг")
                .selectFirstClass()
                .assertThatWeightWarningIsDisplayed("Максимальный вес посылки 5-кг");
    }

    @Epic("Посылки")
    @Feature("Оформление внутрироссийских посылок")
    @Story("Оформление ESM")
    @Test(description = "Максимальный вес EMS - 31,5 кг")
    @TmsLink("197")
    public void createEmsParcelTest() {
        app.openParcelsPage()
                .fillSenderAddress("Москва Мофсфильмовская")
                .fillRecipientAddress("Спб")
                .fillWeight("6 кг")
                .selectFirstClass()
                .assertThatWeightWarningIsDisplayed("Максимальный вес посылки 31,5-кг");
    }
}
