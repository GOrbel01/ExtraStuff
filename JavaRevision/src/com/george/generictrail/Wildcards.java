package com.george.generictrail;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Squall on 08/06/2015.
 */
public class Wildcards {
    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog("Bob"), new Dog("Dave"), new Dog("Doggy"));
        List<String> list = Arrays.asList("Cloud", "Squall", "Zidane", "Tidus");
        printFirstVal(list);
    }

    public static void printFirstVal(List<?> list) {
        System.out.println(list.get(0));
    }

    public static void lowerBoundFirst(List<? super Animal> list) {
        System.out.println(list.get(0));
    }

    public static void upperBoundFirst(List<? extends Animal> list) {
        System.out.println(list.get(0).getName());
    }
}
