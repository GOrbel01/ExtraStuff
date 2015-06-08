package com.george.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Cloud on 08/06/2015.
 */
public class Incrementor extends RecursiveTask<Integer> {
    public static ForkJoinPool fjPool = new ForkJoinPool();
    int theNumber;

    Incrementor(int x) {
        theNumber = x;
    }

    public Integer compute() {
        return theNumber + 1;
    }

    public static void main(String[] args) {
        int fortyThree = fjPool.invoke(new Incrementor(42));
        System.out.println(fortyThree);
    }
}
