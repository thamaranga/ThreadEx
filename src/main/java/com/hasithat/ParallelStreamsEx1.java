package com.hasithat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamsEx1 {

    private int transform(int num){
        System.out.println(num+"---"+Thread.currentThread().getName());
        return num*10;
    }

    private  List<Integer> sequentialExecution(){
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> numbersList = numbers.stream().map(this::transform).collect(Collectors.toList());
        return numbersList;

    }

    private  List<Integer> parallelExecution(){
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> numbersList = numbers.parallelStream().map(this::transform).collect(Collectors.toList());
        return numbersList;

    }

    public static void main(String[] args) {
        ParallelStreamsEx1 parallelStreamsEx1= new ParallelStreamsEx1();
        System.out.println("*************************** Start sequential execution ***************************");
        parallelStreamsEx1.sequentialExecution();
        System.out.println("*************************** End sequential execution ***************************");

        System.out.println("*************************** Start parallel execution ***************************");
        parallelStreamsEx1.parallelExecution();
        System.out.println("*************************** End parallel execution ***************************");
    }
}
