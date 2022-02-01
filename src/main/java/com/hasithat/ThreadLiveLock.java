package com.hasithat;

public class ThreadLiveLock {

    static final Customer customer = new Customer();
    static final Shop shop = new Shop();
    /*
    *livelock may happen if two or more threads are busy responding to the action of
    * each other and unable to make further progress in the process.
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> customer.payMoney(shop));

        Thread thread2 = new Thread(() -> shop.shipOrder(customer));

        thread1.start();
        thread2.start();
    }
}

class Customer{
    private boolean paid = false;
    //Customer is waiting until order ship for doing the payment
    public void payMoney(Shop shop){
        while(!shop.isOrderShipped()){
            System.out.println("waiting for order");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        setPaid(true);
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}

class Shop{
    private boolean orderShipped = false;
    //Shop is waiting until  customer doing the payment for shiping the item
    public void shipOrder(Customer customer){
        while(!customer.isPaid()){
            System.out.println("waiting for money");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        setOrderShipped(true);
    }

    public void setOrderShipped(boolean orderShipped) {
        this.orderShipped = orderShipped;
    }

    public boolean isOrderShipped() {
        return orderShipped;
    }
}
