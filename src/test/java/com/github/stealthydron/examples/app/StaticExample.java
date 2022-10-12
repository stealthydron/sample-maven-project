package com.github.stealthydron.examples.app;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class StaticExample {

    @Step("Get something step")
    public static String getSomething() {
        return "something";
    }

    @Step("do something with param {param} 123123")
    public static void doSomething(String param){
        Allure.addAttachment("test","test content");
        System.out.println("do something with param:"+param);
    }
}
