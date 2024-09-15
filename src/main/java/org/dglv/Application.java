package org.dglv;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.dglv.model.Geoscan701;
import org.dglv.model.Geoscan801;

import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        var context = Micronaut.run(Application.class, args);

        //1. An example of Embedded Async annotation
        runEmbeddedAroundAdviceAsyncExample(context);
        //2. An example of AOP Around Advice
        runAOPAroundAdviceExample(context);

        context.close();
    }

    public static void runEmbeddedAroundAdviceAsyncExample(ApplicationContext context) throws InterruptedException {
        var asyncExample = context.getBean(AsyncExample.class);
        // Proxy class is org.dglv.$AsyncExample$Definition$Intercepted
        System.out.println("Calling sleep() method on " + asyncExample.getClass().getName());
        asyncExample.sleep(2000);
        System.out.println("After sleep() method. Done!");
    }

    public static void runAOPAroundAdviceExample(ApplicationContext context) {
        var uav701 = context.createBean(Geoscan701.class, 111);
        var uav801 = context.createBean(Geoscan801.class, 222);

        Stream.of(uav701, uav801)
                .forEach(System.out::println);
    }

}