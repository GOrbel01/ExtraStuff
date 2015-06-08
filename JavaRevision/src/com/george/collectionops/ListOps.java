package com.george.collectionops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cloud on 06/06/2015.
 */
public class ListOps {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("Cloud", "Squall", "Zidane", "Tidus", "Tifa", "Rinoa", "Garnet", "Yuna");
        List<String> testList = new ArrayList<String>();
        testList.addAll(strs);
        testList.add(3, "Aeris");
        testList.remove(2);
        testList.iterator().forEachRemaining((s) -> System.out.println(s));
    }
}
