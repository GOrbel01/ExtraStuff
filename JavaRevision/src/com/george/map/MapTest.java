package com.george.map;

/**
 * Created by Squall on 30/05/2015.
 */
public class MapTest {
    public static void main(String[] args) {
        TestMap<Integer, String> map = new TestMap<>();
        map.add(4, "Good");
        map.add(2, "Bad");
        map.add(3, "Ok");
        map.add(1, "Gaddam");
        map.add(1, "Messi");
        map.printMap();
        System.out.println(map.get(2));
    }
}
