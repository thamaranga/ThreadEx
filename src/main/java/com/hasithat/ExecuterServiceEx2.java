package com.hasithat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceEx2 {

    public static void main(String[] args) {

        //Get count of available cores (One core can execute an one thread at a time)
        int coreCount= Runtime.getRuntime().availableProcessors();
        System.out.println("coreCount "+coreCount);
        ExecutorService executorService= Executors.newFixedThreadPool(coreCount);

        for (int i = 0; i <100 ; i++) {
            //ExecutorService execute method is not returned anything.
            executorService.execute(new CPUIntensiveTask());
        }

        executorService.shutdown();

    }

    static class CPUIntensiveTask implements Runnable{

        @Override
        public void run() {
            //Let's simulate below task as the CPU intensive task.
            for(int i=0; i<100000; i++){

            }
            System.out.println("Thread name : "+Thread.currentThread().getName());
        }
    }
}
