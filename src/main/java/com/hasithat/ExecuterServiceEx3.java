package com.hasithat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterServiceEx3 {

    public static void main(String[] args) {

        //Here only one thread will be created.
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        /*Here ExecutorService submit method is called. If task is completed successfully  submit method should return null
          The main difference between ExecutorService submit method and execute method is execute method doesn't return anything and submit method has a return type.
          * */

        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread name : " + Thread.currentThread().getName());

            }
        });

        try {
            System.out.println("Result is " + submit.get());
        }catch(Exception ex){
            System.out.println(ex);
        }

        executorService.shutdown();

    }
}
