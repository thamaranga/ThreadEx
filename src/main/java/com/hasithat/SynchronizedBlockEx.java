package com.hasithat;

public class SynchronizedBlockEx {

    public static void main(String[] args) {

        SyncBlockCounter c= new SyncBlockCounter();

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

class SyncBlockCounter{
    int count=0;

    public  void increment(){
        //Like below we can add synchronized key word only for relevant code block. (No need to add for whole method)
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
