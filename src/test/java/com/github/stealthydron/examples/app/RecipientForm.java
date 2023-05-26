package com.github.stealthydron.examples.app;

import io.qameta.allure.Step;

public class RecipientForm {
    
    public void fillForm(String name, String phone){
        fillName(name);
        fillPhone(phone);
    }

    @Step("Заполнить телефон получателя")
    private void fillPhone(String phone) {
    }

    @Step("Заполнить адрес получателя")
    private void fillAddress(String address) {
    }

    @Step("Заполнить ФИО получателя")
    private void fillName(String name) {
    }
}
