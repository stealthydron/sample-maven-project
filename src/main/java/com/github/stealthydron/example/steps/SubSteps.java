package com.github.stealthydron.example.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class SubSteps {

    @Step("- Дополнительный шаг 1")
    public void subStep1() {
        System.out.println("- Дополнительный шаг 1");
    }

    @Step("- Дополнительный шаг 2")
    public void subStep2() {
        System.out.println("- Дополнительный шаг 2");
        subStep2SubStep();
        Allure.addAttachment("test", "text/html", "test allure attachment");
    }

   @Step("-- вложенный шаг в 'Дополнительный шаг 2'")
    public void subStep2SubStep(){
       System.out.println("-- вложенный шаг в 'Дополнительный шаг 2'");
   }
}
