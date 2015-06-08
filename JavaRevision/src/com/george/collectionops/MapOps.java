package com.george.collectionops;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Cloud on 08/06/2015.
 */
public class MapOps {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 4);
        map.put(2, 8);
        map.put(3, 3);
        map.put(4, 6);
        Set<Integer> keys = map.keySet();
        keys.iterator().forEachRemaining((n) -> System.out.println(n));
        System.out.println();
        printMap(map, keys);
    }

    public static void printMap(Map<Integer, Integer> map, Set<Integer> keys) {
        for (int n : keys) {
            System.out.println(map.get(n));
        }
    }
}
