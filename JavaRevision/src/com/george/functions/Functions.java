package com.george.functions;

import java.util.List;

/**
 * Created by Cloud on 07/06/2015.
 */
public class Functions {
    public static <T> void printList(List<T> list) {
        for (T elem : list) {
            System.out.println(elem);
        }
    }
}
