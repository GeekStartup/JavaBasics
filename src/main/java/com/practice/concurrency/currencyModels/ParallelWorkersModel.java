package com.practice.concurrency.currencyModels;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    // This method is run by a thread in the pool
    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate actual work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupt flag
        }
        System.out.println("Task " + taskId + " completed");
    }
}

public class ParallelWorkersModel {
    public static void main(String[] args) throws InterruptedException {

        int numberOfWorkers = 10;   // Number of parallel threads
        int numberOfTasks = 10;    // Total tasks to submit

        // Create a thread pool with workers
        ExecutorService executor = Executors.newFixedThreadPool(numberOfWorkers);
        //Start timer
        long startTime = System.nanoTime();

        //Submit 10 tasks (delegator)
        for (int i = 1; i <= numberOfTasks; i++) {
            Task task = new Task(i);       // Create a task
            executor.submit(task);         // Send it to worker pool
        }

        executor.shutdown(); // No more tasks will be accepted
        //Wait up to 1 minute for tasks to complete
        boolean finished = executor.awaitTermination(1, TimeUnit.MINUTES);
        long endTime = System.nanoTime();
        //Calculate total time in milliseconds
        long totalTimeMillis = (endTime - startTime) / 1000000;

        if (finished) {
            System.out.println("======All tasks completed within the timeout.====== " + Thread.currentThread().getName());
        } else {
            System.out.println("======Timeout reached. Some tasks may not have finished.====== " + Thread.currentThread().getName());
        }
        System.out.println("Total time taken: " + totalTimeMillis + " ms " + Thread.currentThread().getName());
    }
}
