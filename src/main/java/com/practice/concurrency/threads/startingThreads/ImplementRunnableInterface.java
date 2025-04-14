package com.practice.concurrency.threads.startingThreads;

public class ImplementRunnableInterface implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementRunnableInterface());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
}
