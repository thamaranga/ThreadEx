package com.hasithat;

public class SynchronizedMethodEx {

    public static void main(String[] args) {

        SyncCounter c= new SyncCounter();

        try {
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    c.increment();
                }
            }
            );

            Thread t2= new Thread(()->{
                for (int i = 0; i < 10000; i++) {
                    c.increment();
                }
            }
            );
            t1.start();
            t2.start();

            //We are asking main thread to wait until t1 and t2 complete there tasks.
            t1.join();
            t2.join();
            /*Here below output will  print as 20000 since increment method is defined as a synchronized method.
             */
            System.out.println(c.getCount());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}

class SyncCounter{
    int count=0;

    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}


