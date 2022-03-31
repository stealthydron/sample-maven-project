package com.github.stealthydrom.examples.app;

import io.qameta.allure.Step;

public class StaticExample {

    @Step("Get something step")
    public static String getSomething() {
        return "something";
    }

    @Step("do something with param {param}")
    public static void doSomething(String param){
        System.out.println("do something with param:"+param);
    }
}
