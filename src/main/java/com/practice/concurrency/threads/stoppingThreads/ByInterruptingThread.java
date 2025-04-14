package com.practice.concurrency.threads.stoppingThreads;

public class ByInterruptingThread {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            Thread thread = Thread.currentThread();
            try {
                while (!thread.isInterrupted()) {
                    System.out.println("Thread running " + thread.getName());
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted " + thread.getName());
            }
            System.out.println("Thread is stopped " + thread.getName());
        };

        Thread task = new Thread(runnable);
        task.start();

        Thread.sleep(2000);
        task.interrupt();

    }
}