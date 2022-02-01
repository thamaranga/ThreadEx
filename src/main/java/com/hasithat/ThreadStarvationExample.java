package com.hasithat;

public class ThreadStarvationExample {

    public static synchronized void  performTheTask(){
        try {
            System.out.println("Doing some heavy processing for thread " +
                    Thread.currentThread().getName());
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    * If a thread is unable to gain regular access to shared resources
    *  and is unable to make progress it is called thread starvation in Java multi-threading.
    * In the code thread t1 has been assigned the maximum thread priority and it calls
    * the synchronized method thrice. Where as thread t2 has been assigned the minimum thread
    *  priority and it calls the synchronized method only once but it has to wait for all
    * the three calls of thread t1 to execute the synchronized method.
    * */
    public static void main(String[] args) {

        Thread t1= new Thread(
                ()->{
                    performTheTask();
                    performTheTask();
                    performTheTask();
                }
        );


        Thread t2= new Thread(
                ()->{
                    performTheTask();

                }
        );

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
