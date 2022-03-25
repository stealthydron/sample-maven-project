package com.github.stealthydrom.examples.app;

import io.qameta.allure.Step;

public class SenderForm {
    
    public void fillForm(){
        fillName();
        fillAddress();
        fillPhone();
    }

    @Step("Заполнение телефона отправителя")
    private void fillPhone() {
    }

    @Step("Заполнение адреса отправителя")
    private void fillAddress() {
    }

    @Step("Заполнение имени отправителя")
    private void fillName() {
    }
}
