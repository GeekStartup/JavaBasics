package com.practice.concurrency.threads.stoppingThreads;

class Task implements Runnable {

    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            try {
                System.out.println("Thread running " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted " + Thread.currentThread().getName());
            }
        }
        System.out.println("======Thread Stopped====== " + Thread.currentThread().getName());
    }

    public void stopThread() {
        isRunning = false;
    }
}

public class UsingVolatileBooleanFlag {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(task);
        thread1.start();
        Thread.sleep(2000);

        task.stopThread();

    }
}

