package com.practice.concurrency.threads.startingThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImplementationUsingExecutorService {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Thread running: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(runnable);
        executorService.shutdown();

    }
}
