package com.george.testGenerics;

/**
 * Created by Cloud on 01/12/2014.
 */
public class BoxDriver {
    public static void main(String[] args)
    {
        Box<? extends Number> numBox = new Box<Integer>(31);
    }

}
