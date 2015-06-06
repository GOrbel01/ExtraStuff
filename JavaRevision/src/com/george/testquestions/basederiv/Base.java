package com.george.testquestions.basederiv;

/**
 * Created by Squall on 06/06/2015.
 */
public class Base {
    public void methodOne() {
        System.out.println("A");
        methodTwo();
    }

    public void methodOne(int a) {
        System.out.println("W");
        methodTwo();
    }

    public void testMethA() {
        System.out.println("TESTING_AAA");
        testMethB();
    }

    public void testMethB() {
        System.out.println("TESTING_BBB");
    }

    public void methodTwo() {
        System.out.print("B");
    }
}
