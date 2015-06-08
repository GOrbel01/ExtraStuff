package com.george.concurrency;

/**
 * Created by Cloud on 08/06/2015.
 */
public class SimpleWorker implements Runnable {

    private String name;


    private int result = 0;
    private boolean resultReady = false;

    private final Object obj = new Object();

    public SimpleWorker(String name) {
        this.name = name;
    }

    public void run() {
        synchronized (this) {
            int num = 0;
            for (int i = 0; i < 2000000000; i++) {
                num += i;
            }
            this.result = num;
            resultReady = true;
            notifyAll();
        }
    }

    public int getResult() {
        synchronized (this) {
            while (!resultReady) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    // Nothing to do, just sleep less
                }
            }
            resultReady = false;
            System.out.println(name + ": Finished.");
            return result;
        }
    }
}
