package com.george.concurrency.notify;

/**
 * Created by Cloud on 08/06/2015.
 */
public class NotifyTest implements Runnable {

    private boolean resultReady = false;

    private int id;
    private static int COUNT = 0;

    public NotifyTest() {
        COUNT++;
        id = COUNT;
    }

    public void run() {
        System.out.println("THREAD: " + id + " Running...");
        synchronized(this) {
            try {
                if (id == 1) {
                    Thread.sleep(5000);
                }
                else {
                    Thread.sleep(14000);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            resultReady = true;
            notifyAll();
        }
    }

    public void postRun() {
        synchronized(this) {
            while (!resultReady) {
                try {
                    wait();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            resultReady = false;
            System.out.println("READY ON T: " + id);
        }
    }
}
