package com.practice.concurrency.threads.startingThreads;

public class LambdaExpressionToImplementRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Thread running: " + Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
