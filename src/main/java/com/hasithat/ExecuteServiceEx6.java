package com.hasithat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteServiceEx6 {

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
            //invokeAll method executes all the tasks
            List<Future<String>> futures = executorService.invokeAll(callables);

            for (Future<String> future : futures) {
                System.out.println("future.get = " + future.get());
            }

            executorService.shutdown();
        }catch(Exception ex){
            System.out.println(ex);
        }

    }
}
