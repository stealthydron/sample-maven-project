package com.github.stealthydrom.examples.test;

import com.github.stealthydrom.examples.app.Application;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class InternationalParcelTest {

    private final Application app = new Application();

    @Epic("Международные посылки")
    @Feature("Оформление международных посылок")
    @Story("Посылка в геоманию")
    @Test(description = "Для посылки москва - германия формируется бланк ...")
    @TmsLink("189")
    public void createParcelTest() {
        app.openParcelsPage()
                .fillSenderAddress("Москва Мофсфильмовская")
                .fillRecipientAddress("Спб")
                .fillWeight("1 кг")
                .checkOut()
                .fillSender()
                .fillRecipient();
    }

    @Epic("Международные посылки")
    @Feature("Оформление международных посылок")
    @Story("Мелкий пакет")
    @Test(description = "Мелкий пакет 2.5 кг заказной")
    @TmsLink("191")
    public void createFirstClassParcelTest() {
        app.openParcelsPage()
                .fillSenderAddress("Москва Мофсфильмовская")
                .fillRecipientAddress("Спб")
                .fillWeight("6 кг")
                .selectFirstClass()
                .assertThatWeightWarningIsDisplayed("Сообщение для мелкого пакета...");
    }

    @Epic("Международные посылки")
    @Feature("Оформление международных посылок")
    @Story("Оформление ESM")
    @Test(description = "Максимальный вес EMS - 30 кг")
    @TmsLink("193")
    public void createEmsParcelTest() {
        app.openParcelsPage()
                .fillSenderAddress("Москва Мофсфильмовская")
                .fillRecipientAddress("Спб")
                .fillWeight("6 кг")
                .selectFirstClass()
                .assertThatWeightWarningIsDisplayed("Максимальный вес посылки 30");
    }
}