package com.hasithat;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinEx2 {

    public static void main(final String[] arguments)  {

        try {
            int nThreads = Runtime.getRuntime().availableProcessors();
            System.out.println(nThreads);

            String longSentence="Currentely Sri Lanka is facing for a very critical economic crisis";


            //This is like a thread pool
            ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
            forkJoinPool.invoke(new ForkJoinEx2.WordProcesser(longSentence));

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /*RecursiveTask class is used for computations which returns a value.
    (RecursiveAction class is used when nothing is returned)
     */
    static class WordProcesser extends RecursiveAction {
        private String sentence;

        WordProcesser(String sentence) {
            this.sentence=sentence;
        }



        @Override
        protected void compute() {
            if(sentence.length()<=1){
                System.out.println(sentence.toUpperCase() +" Printed By "+Thread.currentThread().getName());
            }else{
                WordProcesser wordProcesser1= new WordProcesser(sentence.substring(0,sentence.length()/2));
                WordProcesser wordProcesser2= new WordProcesser(sentence.substring(sentence.length()/2));
                //When using invokeAll method no need to use fork and join methods
                ForkJoinTask.invokeAll(wordProcesser1, wordProcesser2);
            }
        }
    }
}
