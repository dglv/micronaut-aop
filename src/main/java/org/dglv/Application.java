package org.dglv;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import org.dglv.model.Geoscan701;
import org.dglv.model.Geoscan801;

import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        var context = Micronaut.run(Application.class, args);

        //1. Example of AOP Around Advice
        runAOPAroundAdviceExample(context);

        context.close();
    }

    public static void runAOPAroundAdviceExample(ApplicationContext context) {
        var uav701 = context.createBean(Geoscan701.class, 111);
        var uav801 = context.createBean(Geoscan801.class, 222);

        Stream.of(uav701, uav801)
                .forEach(System.out::println);
    }


}