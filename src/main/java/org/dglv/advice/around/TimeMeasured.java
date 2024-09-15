package org.dglv.advice.around;

import io.micronaut.aop.Around;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Around
public @interface TimeMeasured {
}
