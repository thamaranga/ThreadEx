package com.hasithat;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {
    public static void main(final String[] arguments)  {

        try {
            int nThreads = Runtime.getRuntime().availableProcessors();
            System.out.println(nThreads);

            int[] numbers = new int[1000];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i;
            }

            //This is like a thread pool
            ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
            Long result = forkJoinPool.invoke(new Sum(numbers, 0, numbers.length));
            System.out.println(result);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /*RecursiveTask class is used for computations which returns a value.
    (RecursiveAction class is used when nothing is returned)
     */
    static class Sum extends RecursiveTask<Long> {
        int low;
        int high;
        int[] array;

        Sum(int[] array, int low, int high) {
            this.array = array;
            this.low   = low;
            this.high  = high;
        }

        //Inside compute method we need to implement our task
        protected Long compute() {

            /*If the given work is small enough  it will be done by the first block
            * unless task will be done by the second block*/
            if(high - low <= 10) {
                long sum = 0;

                for(int i = low; i < high; ++i) {
                    sum += array[i];

                }
                System.out.println(sum + " Printed By " + Thread.currentThread().getName());
                return sum;
            } else {
                int mid = low + (high - low) / 2;
                Sum left  = new Sum(array, low, mid);
                Sum right = new Sum(array, mid, high);
                /*Fork is a process in which a task splits itself into smaller and
                 independent sub-tasks which can be executed concurrently.
                 */
                left.fork();
                right.fork();
                /*Join is a process in which a task join all the results of sub-tasks
                once the subtasks have finished executing, otherwise it keeps waiting.
                * */
                long leftResult = left.join();
                long rightResult = right.join();
                return leftResult + rightResult;
            }
        }
    }

}
