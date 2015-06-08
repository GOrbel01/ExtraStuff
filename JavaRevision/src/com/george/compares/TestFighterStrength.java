package com.george.compares;

/**
 * Created by Squall on 08/06/2015.
 */
public class TestFighterStrength {
    public static <T extends Comparable<T>> T compareFighters(T f1, T f2) {
        return (f1.compareTo(f2) == 1) ? f1 : f2;
    }
}
