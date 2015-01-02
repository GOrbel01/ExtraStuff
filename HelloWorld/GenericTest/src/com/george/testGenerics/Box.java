package com.george.testGenerics;

/**
 * Created by Cloud on 01/12/2014.
 */
public class Box<E> {
    E data;

    public Box(E data)
    {
        this.data = data;
    }

    public E getData()
    {
        return data;
    }

    public void copyFrom(Box<E> b)
    {
        this.data = b.getData();
    }

}
