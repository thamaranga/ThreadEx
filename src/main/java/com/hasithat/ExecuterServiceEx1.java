package com.hasithat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceEx1 {

    public static void main(String[] args) {
        //Here 10 threads are crated
        ExecutorService service= Executors.newFixedThreadPool(10);

        //Below 100 tasks will be executed by above ten threads
        for (int i=0;i<100; i++){
            service.execute(new Task());
        }
        service.shutdown();
        System.out.println("End of main method...");
    }


    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread name : "+Thread.currentThread().getName());
        }
    }
}
