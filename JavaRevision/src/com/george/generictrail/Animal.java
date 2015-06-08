package com.george.generictrail;

/**
 * Created by Squall on 08/06/2015.
 */
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
