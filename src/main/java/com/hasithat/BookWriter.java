package com.hasithat;

public class BookWriter implements  Runnable {

    Book book;

    public BookWriter(Book book) {
        super();
        this.book = book;
    }

    @Override
    public void run() {
        synchronized (book) {
            System.out.println("Author is Starting book : " +book.getTitle() );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            book.setCompleted(true);
            System.out.println("Book has been completed now");

            //This is how notify calls
            /*book.notify();
            System.out.println("notify one reader");*/

            //This is how notifyAll calls
            book.notifyAll();
            System.out.println("notify all readers");

        }
    }
}
