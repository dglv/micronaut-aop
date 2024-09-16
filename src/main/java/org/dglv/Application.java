package org.dglv;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.dglv.advice.around.model.Aircraft701;
import org.dglv.advice.around.model.Copter801;
import org.dglv.advice.around_async.AsyncExample;
import org.dglv.advice.introduction.EmailService;

import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        var context = Micronaut.run(Application.class, args);

        //1. The example of Embedded Async annotation
        runEmbeddedAroundAdviceAsyncExample(context);
        //2. The example of AOP Around Advice
        runAOPAroundAdviceExample(context);
        //3. The example of AOP Introduction Advice
        runAOPIntroductionAdviceExample(context);

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
        var uav701 = context.createBean(Aircraft701.class, 111);
        var uav801 = context.createBean(Copter801.class, 222);

        Stream.of(uav701, uav801)
                .forEach(System.out::println);
    }

    public static void runAOPIntroductionAdviceExample(ApplicationContext context) {
        context.getBean(EmailService.class).sendEmail("Hello world!", "user@gmail.com");
    }

}