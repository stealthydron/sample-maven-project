package com.github.stealthydron.example.testit.annotation;

import io.qameta.allure.LinkAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@LinkAnnotation(
        type = "autotest"
)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutotestId {

    String value();
}