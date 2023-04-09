package com.hasithat;

/*This example demonstrates how thread can be communicated each other using
* wait , notify and notifyall methods

wait():
When you call wait method on the object then it tell threads to give up
the lock and go to sleep state unless and until some other thread enters
in same monitor and calls notify or notifyAll methods on it.
notify():
When you call notify method on the object, it wakes one of thread waiting
for that object. So if multiple threads are waiting for an object,
it will wake of one of them. Now you must be wondering which one it will wake up.
It actually depends on OS implementation.
notifyAll() :
notifyAll will wake up all threads waiting on that object unlike
notify which wakes up only one of them.
Which one will wake up first depends on thread priority and OS implementation.
 */
public class ThreadInterCommunication {

    public static void main(String args[])
    {
        // Book object on which wait and notify method will be called
        Book book=new Book("OCJP preparation guide");

        BookReader hasithaReader=new BookReader(book);
        BookReader kasunReader=new BookReader(book);

        // BookReader threads which will wait for completion of book
        Thread hasithaThread=new Thread(hasithaReader,"hasitha");
        Thread kasunThread=new Thread(kasunReader,"kasun");

        hasithaThread.start();
        kasunThread.start();

        // To ensure both readers started waiting for the book
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        // BookWriter thread which will notify once book get completed
        BookWriter bookWriter=new BookWriter(book);
        Thread bookWriterThread=new Thread(bookWriter);
        bookWriterThread.start();

    }
}
