package org.dglv.advice.around;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.annotation.Nullable;
import jakarta.inject.Singleton;

import java.util.concurrent.TimeUnit;

@Singleton
@InterceptorBean(TimeMeasured.class)
public class TimeMeasuredInterceptor implements MethodInterceptor<Void, String> {

    @Nullable
    @Override
    public String intercept(MethodInvocationContext<Void, String> context) {
        long startTime = System.nanoTime();
        var result = context.proceed();
        long endTime = System.nanoTime();
        System.out.println("Processing time took " +
                TimeUnit.NANOSECONDS.toMicros(endTime - startTime) + " microseconds.");
        return result;
    }
}
