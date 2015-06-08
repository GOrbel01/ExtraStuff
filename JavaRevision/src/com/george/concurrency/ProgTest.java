package com.george.concurrency;

/**
 * Created by Cloud on 08/06/2015.
 */
public class ProgTest {

    SimpleWorker w1 = null;
    SimpleWorker w2 = null;

    public static void main(String[] args) {
        ProgTest pt = new ProgTest();
        pt.launch();
    }

    public void launch() {
        long start, stop;
        w1 = new SimpleWorker("W1");
        w2 = new SimpleWorker("W2");
        start = System.currentTimeMillis();
        runWorkers();
        stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop - start) + "ms");
    }

    public void runWorkers() {
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        t1.start();
        t2.start();
        int d1 = w1.getResult();
        int d2 = w2.getResult();
        System.out.println("Result: " + d1 + d2);
    }
}
