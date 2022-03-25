package com.github.stealthydrom.examples.app;

import io.qameta.allure.Step;

public class RecipientForm {
    
    public void fillForm(){
        fillName();
        fillAddress();
        fillPhone();
    }

    @Step("Заполнение телефона получателя")
    private void fillPhone() {
    }

    @Step("Заполнение адреса получателя")
    private void fillAddress() {
    }

    @Step("Заполнение имени получателя")
    private void fillName() {
    }
}
