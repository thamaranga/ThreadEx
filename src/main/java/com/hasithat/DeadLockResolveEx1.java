package com.hasithat;

public class DeadLockResolveEx1 {

    /*
    * We can avoid the deadlock situation in the DeadLockEx1 class by changing the resource access order
    * */
    public static void main(String[] args) {
        final String resource1 = "I am resource 01";
        final String resource2 = "I am resource 02";

        // t1 tries to lock resource1 then resource2
        Thread t1= new Thread(() ->{
           synchronized (resource1){
               System.out.println("Thread 1: locked resource 1");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   System.out.println(e.getMessage());
               }
               synchronized (resource2) {
                   System.out.println("Thread 1: locked resource 2");
               }
           }
        });
        // t2 tries to lock resource2 then resource1
        Thread t2= new Thread(() ->{
            synchronized (resource1){
                System.out.println("Thread 2: locked resource 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");
                }
            }
        });

        t1.start();
        t2.start();



    }
}
