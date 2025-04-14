package com.practice.concurrency.threads.stoppingThreads;

public class ThreadStopExample {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                while (true) {
                    System.out.println("Thread is running " + Thread.currentThread().getName());
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            } finally {
                // This block may not execute if the thread is stopped using stop()
                System.out.println("Cleaning up...");
            }
        };

        Thread thread = new Thread(runnable);
        // Start the thread
        thread.start();

        // Let it run for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the thread forcefully (unsafe)
        System.out.println("Calling stop()... (unsafe)");
        thread.stop(); // ❌ Not recommended

        System.out.println("Main thread exiting.");
    }
}
