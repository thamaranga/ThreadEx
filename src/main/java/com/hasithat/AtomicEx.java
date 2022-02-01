package com.hasithat;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicEx {

    public static void main(String[] args) {

        AtomicBoolean atomicBoolean= new AtomicBoolean();
        AtomicInteger atomicInteger= new AtomicInteger();

        AtomicLong atomicLong= new AtomicLong(1L);
        AtomicReference<String> atomicReference= new AtomicReference<>("Hello world");


        System.out.println("atomicBoolean value = "+atomicBoolean.get());
        System.out.println("atomicInteger value = "+atomicInteger.get());
        System.out.println("atomicLong value = "+atomicLong.get());
        System.out.println("atomicReference value = "+atomicReference.get());


        AtomicReference<String> text= new AtomicReference<>("OCPJP");

        //compareAndSet method compare first argument with variable value. If they are equal second argument value is assigned to the variable value
        text.compareAndSet("OCAJP", "Whizlabs");
        System.out.println("text "+text);


        text.compareAndSet("OCPJP", "Whizlabs");
        System.out.println("text "+text);

        //getAndSet method assigns current value of atomicBoolean to boolValue and then assigns parameter value to atomicBoolean variable
        boolean boolValue=atomicBoolean.getAndSet(true);
        System.out.println("boolValue = "+boolValue);

        ////set method assigns parameter value to atomicBoolean variable and doesn't return anything
        atomicBoolean.set(false);

        /*
        * AtomicInteger and AtomicLong classes defines getAndIncrement , incrementAndGet, getAndAdd , addAndGet, decrementAndGet , getAndDecrement methods.
        * */

        AtomicInteger myAtomicInteger= new AtomicInteger(5);
        //Assigns myAtomicInteger variable value to value1 and then increments myAtomicInteger value by one.
        int value1=myAtomicInteger.getAndIncrement();
        System.out.println("value1 = "+value1);
        //Assigns myAtomicInteger variable value to value2 and then add parameter value to  myAtomicInteger value.
        int value2=myAtomicInteger.getAndAdd(-5);
        System.out.println("value2 = "+value2);
        //Decrement myAtomicInteger variable value by one and then assigns it  to  value3 variable.
        int value3=myAtomicInteger.decrementAndGet();
        System.out.println("value3 = "+value3);

        AtomicInteger myAtomicInteger02= new AtomicInteger(2);
        int intValue1=myAtomicInteger02.updateAndGet(i->7*i);
        System.out.println("intValue1 = "+intValue1);
        int intValue2=myAtomicInteger02.accumulateAndGet(12, (i1, i2)->i1+i2);
        System.out.println("intValue2 = "+intValue2);

        AtomicReference<String> atomicRef= new AtomicReference<>("WHIZLABS");
        String text2=atomicRef.getAndUpdate(i->i.toLowerCase());
        System.out.println("text2 = "+text2);
        String text3=atomicRef.getAndAccumulate("Welcome to ",(i1, i2)->i2+i1);
        System.out.println("text3 = "+text3);
        System.out.println("atomicRef = "+atomicRef.get());




    }
}
