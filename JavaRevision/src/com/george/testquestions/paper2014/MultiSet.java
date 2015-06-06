package com.george.testquestions.paper2014;

/**
 * Created by Cloud on 06/06/2015.
 */
public interface MultiSet {
    int size();

    boolean contains(String s);

    int occurrences(String s);

    void add(String s);

    boolean remove(String s);
}
