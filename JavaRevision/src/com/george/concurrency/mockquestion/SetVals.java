package com.george.concurrency.mockquestion;

import java.util.Scanner;

/**
 * Created by Cloud on 08/06/2015.
 */
public class SetVals extends Thread {

    private Queue queue;

    public SetVals(Queue oneQ) {
        queue = oneQ;
    }

//    @Override
//    public void run() {
//        Integer ch = 0;
//        Scanner sc = new Scanner(System.in);
//            while (num != -1) {
//                num = sc.nextInt();
//                queue.enqueue(num);
//            }
//    }
}
