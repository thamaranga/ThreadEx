package com.hasithat;

import java.util.concurrent.CyclicBarrier;

/*
* CyclicBarrier is a synchronization class that allows a set of threads to wait for each other when reaching a common barrier point.
* */
public class CyclicBarrierEx1 {

    public static void main(String[] args) {
        System.out.println("Main thread  started.....");
        //With below CyclicBarrier we will block two threads until each of them reached to the barrier. (Until all the threads printing 'is waiting on barrier' message)
        //Below sout message (Threads released) will be printed after all the threads crossed the barrier.
        /*When executing barrier.await() method by a thread, its initial value (here 2) will be decremented by one. So, when barrier.await() returned value is 0
        barrier will be released all the threads.*/
        CyclicBarrier barrier=new CyclicBarrier(2, ()-> System.out.println("Threads released"));
        Runnable task1=()->{

                try{
                    System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                   int result= barrier.await();
                   System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
                }catch(Exception ex){

                }



        };

        Runnable task2=()->{

                try{
                    System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                    int result=barrier.await();
                    System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
                }catch(Exception ex){

                }



        };

        new Thread(task1).start();
        new Thread(task2).start();
        System.out.println("Main thread finished.....");
    }


}
