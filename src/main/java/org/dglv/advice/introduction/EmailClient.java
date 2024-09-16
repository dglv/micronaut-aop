package org.dglv.advice.introduction;

import io.micronaut.aop.Introduction;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Introduction
public @interface EmailClient {
}
