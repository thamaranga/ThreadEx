package com.hasithat;

public class RaceConditionEx {



    public static void main(String[] args) {

        Counter c= new Counter();

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

            //We are asking main thread to wait until t1 and t2 complete their tasks.
            t1.join();
            t2.join();
            /*Here below output will not print as 20000. This is because single Counter object is shared among several threads.
            *To avoid this situation we have to use Synchronized key  word.
            */
            System.out.println(c.getCount());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }


    }


}

class Counter{
    int count=0;

    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
