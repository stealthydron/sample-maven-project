package com.github.stealthydrom.examples.app;

import io.qameta.allure.Step;

public class Application {


    @Step("Открыть страницу посылки")
    public ParcelsPage openParcelsPage() {
        return new ParcelsPage();
    }
}
