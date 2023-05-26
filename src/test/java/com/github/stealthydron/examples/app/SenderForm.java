package com.github.stealthydron.examples.app;

import io.qameta.allure.Step;

public class SenderForm {

    public void fillForm(String name, String phone){
        fillName(name);
        fillPhone(phone);
    }

    @Step("Заполнить телефон отправителя")
    private void fillPhone(String phone) {
    }

    @Step("Заполнить адрес отправителя")
    private void fillAddress(String address) {
    }

    @Step("Заполнить ФИО отправителя")
    private void fillName(String name) {
    }
}