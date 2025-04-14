package com.practice.concurrency.threads.startingThreads;

public class AnonymousImplementationOfRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running: " + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
