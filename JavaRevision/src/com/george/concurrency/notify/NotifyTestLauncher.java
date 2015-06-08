package com.george.concurrency.notify;

/**
 * Created by Cloud on 08/06/2015.
 */
public class NotifyTestLauncher {

    public static void main(String[] args) {
        NotifyTestLauncher nt = new NotifyTestLauncher();
        nt.launch();
    }

    public void launch() {
        NotifyTest n1 = new NotifyTest();
        NotifyTest n2 = new NotifyTest();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n2);
        t1.start();
        t2.start();
        n1.postRun();
        n2.postRun();
    }
}
