package org.dglv;

import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;

@Singleton
public class AsyncExample {

    @Async
    public void sleep(long mills) throws InterruptedException {
        Thread.sleep(mills);
        System.out.println("Sleeping is over. Thread has waked up!");
    }
}
