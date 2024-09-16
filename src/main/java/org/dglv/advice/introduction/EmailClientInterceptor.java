package org.dglv.advice.introduction;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.type.Argument;
import jakarta.inject.Singleton;

import java.util.Arrays;

@Singleton
@InterceptorBean(EmailClient.class)
public class EmailClientInterceptor implements MethodInterceptor<Object, Object> {
    @Override
    public Object intercept(MethodInvocationContext context) {
        Arrays.stream(context.getArguments())
                .filter(arg -> arg.getAnnotationMetadata().hasAnnotation(To.class))
                .map(Argument::getName)
                .map(str -> context.getParameterValueMap().get(str))
                .forEach(System.out::println);

        return null;
    }
}
