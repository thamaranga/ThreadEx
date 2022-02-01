package com.hasithat;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterServiceEx4 {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        /*Here instead of Runnable object , we are passing a Callable object.So we have to implement call method of Callable interface.
        call method has a return type.(The main difference between Runnable and Callable is Runnable run method return nothing. Callable call method has a return type.)
        */
        Future<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Thread name : " + Thread.currentThread().getName());
                return "Successfully executed...";
            }
        });

        try {
            //Here we are retrieving the task execution result through Future object
            System.out.println("Task execution result = " + submit.get());
        }catch(Exception ex){
            System.out.println(ex);
        }

        executorService.shutdown();
    }
}
