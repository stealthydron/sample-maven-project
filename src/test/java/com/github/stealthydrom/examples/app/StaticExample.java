package com.github.stealthydrom.examples.app;

import io.qameta.allure.Step;

public class StaticExample {

    @Step("Get something step")
    public static String getSomething() {
        return "something";
    }
}
