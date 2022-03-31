package com.github.stealthydron.example.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class SubSteps {

    @Step("-sub step1")
    public void subStep1() {
        System.out.println("- sub step1");
    }

    @Step("-sub step2")
    public void subStep2() {
        System.out.println("- sub step2");
        subStep2SubStep();
        Allure.addAttachment("test", "text/html", "test allure attachment");
    }

   @Step("--sub step2 substep")
    public void subStep2SubStep(){
       System.out.println("--sub step2 substep");
   }
}
