package com.hasithat;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceEx5 {

    public static void main(String[] args)  {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Set<Callable<String>> callables = new HashSet<Callable<String>>();
            callables.add(new Callable<String>() {
                public String call() throws Exception {
                    return "Task 1";
                }
            });
            callables.add(new Callable<String>() {
                public String call() throws Exception {
                    return "Task 2";
                }
            });
            callables.add(new Callable<String>() {
                public String call() throws Exception {
                    return "Task 3";
                }
            });

            //invokeAny method executes any  task from above callables
            String result = executorService.invokeAny(callables);

            System.out.println("result = " + result);

            executorService.shutdown();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
