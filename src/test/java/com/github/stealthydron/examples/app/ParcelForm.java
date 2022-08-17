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
    public ParcelForm fillSender() {
        senderForm.fillForm();
        return this;
    }

    @Step("Заполнить получателя")
    public ParcelForm fillRecipient() {
        recipient.fillForm();
        return this;
    }
}
