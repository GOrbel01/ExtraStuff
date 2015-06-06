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
        strSet.addAll(Arrays.asList("Cloud", "Squall", "Zidane", "Tidus", "Tifa", "Rinoa", "Garnet", "Yuna"));
    }
}
