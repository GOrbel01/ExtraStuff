package com.george.testquestions.basederiv;

/**
 * Created by Squall on 06/06/2015.
 */
public class Derived extends Base {

    public static void main(String[] args) {
        Base der = new Derived();
        der.methodOne(0);
        der.testMethA();
    }

    public void methodOne(int a) {
        super.methodOne();
        System.out.println("X");
    }

    public void methodOne(Integer a) {
        super.methodOne();
        System.out.println("C");
    }

    public void testMethA() {
        super.testMethB();
        System.out.println("A_TEST");
    }

    public void testMethB() {
        super.testMethB();
    }

    public void methodTwo() {
        super.methodTwo();
        System.out.println("D");
    }
}
