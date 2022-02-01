package com.hasithat;

public class DeadLockEx1 {

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
            synchronized (resource2){
                System.out.println("Thread 2: locked resource 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        t1.start();
        t2.start();



    }
}
