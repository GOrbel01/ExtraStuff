package com.george.collectionops;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Created by Cloud on 06/06/2015.
 */
public class SetOps {
    public static void main(String[] args) {
        Set<String> strSet = new HashSet<String>();
        Set<String> secSet = new HashSet<String>();
        Set<Integer> intSet = new HashSet<Integer>();
        strSet.addAll(Arrays.asList("Cloud", "Squall", "Zidane", "Tidus", "Tifa", "Rinoa", "Garnet", "Yuna"));
        secSet.add("Cloud");
        secSet.add("Squall");
        secSet.add("Zidane");
        secSet.add("Tidus");
        secSet.add("Tifa");
        secSet.add("Rinoa");
        secSet.add("Garnet");
        secSet.add("Yuna");
        intSet.addAll(Arrays.asList(1, 2, 10, 5, 3, 6, 7, 9));
        System.out.println("Garnet".hashCode());
        System.out.println("Cloud".hashCode());
        System.out.println("Rinoa".hashCode());
        System.out.println("Sec Set");
        printSet(secSet);
        printSet(intSet);
        strSet.add("Test");
        printSet(strSet);
        strSet.add("Test");
        printSet(strSet);
    }

    public static <T> void printSet(Set<T> set) {
        set.iterator().forEachRemaining((s) -> System.out.println(s));
        System.out.println();
    }
}
