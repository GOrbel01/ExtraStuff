package com.george.testquestions.paper2014;

import java.util.List;

/**
 * Created by Cloud on 06/06/2015.
 */
public class Q3 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        System.out.println(arr);
        exchange(arr, 0, 3);

    }

    public static <T> void exchange(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static <T> int max(int begin, List<T> elems) {
//        T temp = null;
//        for (int i = begin; i < elems.size(); i++) {
//            if (temp == null) {
//                temp = elems.get(i);
//            }
//            else {
//                if (elems.get(i) temp) {
//
//                }
//            }
//        }
//    }
}
