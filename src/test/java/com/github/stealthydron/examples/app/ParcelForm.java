package com.github.stealthydron.examples.app;

import io.qameta.allure.Step;

public class ParcelForm {

    private final SenderForm senderForm;
    private final RecipientForm recipient;

    public ParcelForm() {
        this.senderForm = new SenderForm();
        this.recipient = new RecipientForm();
    }

    @Step("Заполнить отправителя")
    public ParcelForm fillSender(String name, String phone) {
        senderForm.fillForm(name,phone);
        return this;
    }

    @Step("Заполнить получателя")
    public ParcelForm fillRecipient(String name, String phone) {
        recipient.fillForm(name,phone);
        return this;
    }

    @Step("Проверка условия '{expectedCondition}'")
    public void assertThatSomething(String expectedCondition) {
    }
}
