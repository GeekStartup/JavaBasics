package com.practice.concurrency.threads.startingThreads;

public class ExtendingThreadClass extends Thread {
    public static void main(String[] args) {
        ExtendingThreadClass startByExtendingThreadClass = new ExtendingThreadClass();
        startByExtendingThreadClass.start();
    }

    @Override
    public void run() {
        System.out.println("Thread is running.." + Thread.currentThread().getName());
    }
}
