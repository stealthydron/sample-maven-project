package com.github.stealthydrom.examples.app;

import io.qameta.allure.Step;

public class ParcelsPage {

    @Step("Ввести адрес отправителя {address}")
    public ParcelsPage fillSenderAddress(String address) {
        return this;
    }

    @Step("Ввести адрес получателя {address}")
    public ParcelsPage fillRecipientAddress(String address) {
        return this;
    }

    @Step("Ввести вес {weight}")
    public ParcelsPage fillWeight(String weight) {
        return this;
    }

    @Step("Нажать оформить")
    public ParcelForm checkOut() {
        return new ParcelForm();
    }

    @Step("Выбрать посылку 1 класса")
    public ParcelsPage selectFirstClass() {
        return this;
    }

    @Step("Проверить, что отображается сообщение {message}")
    public void assertThatWeightWarningIsDisplayed(String message) {
    }
}
