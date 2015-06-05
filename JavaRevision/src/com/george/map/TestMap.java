package com.george.map;

/**
 * Created by Squall on 30/05/2015.
 */
public class TestMap<T, E> {

    private MapNode<T, E> first;

    public TestMap() {

    }

    public void add(T key, E value) throws IllegalArgumentException {
        MapNode<T, E> current = first;
        boolean done = false;
        if (first == null) {
            first = new MapNode<>(key, value);
        }
        else {
            while (!done) {
                if (current.getKey() == key) {
                    throw new IllegalArgumentException("Duplicate Key: \"" + key + "\" for value \"" + value + "\", You Cannot Add This.");
                }
                if (current.getNextNode() == null) {
                    current.setNextNode(new MapNode<>(key, value));
                    done = true;
                }
                else {
                    current = current.getNextNode();
                }
            }
        }
    }

    public E get(T key) {
        MapNode<T, E> current = first;
        E result = null;
        while (current != null) {
            if (current.getKey().equals(key)) {
                result = current.getValue();
            }
            current = current.getNextNode();
        }
        return result;
    }

    public void printMap() {
        MapNode<T, E> current = first;
        while (current != null) {
            System.out.println(current.getKey() + " -> " + current.getValue());
            current = current.getNextNode();
        }
    }
}
