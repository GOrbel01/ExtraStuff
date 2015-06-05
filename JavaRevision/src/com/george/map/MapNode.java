package com.george.map;

/**
 * Created by Squall on 30/05/2015.
 */
public class MapNode<T, E> {

    private T key;
    private E value;

    private MapNode<T, E> nextNode;
    private MapNode<T, E> previousNode;

    public MapNode(T key, E value) {
        this.key = key;
        this.value = value;
        nextNode = null;
    }

    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    public void setPreviousNode(MapNode<T, E> previous) {
        this.previousNode = previous;
    }

    public MapNode<T, E> getPreviousNode() {
        return previousNode;
    }

    public void setNextNode(MapNode<T, E> next) {
        this.nextNode = next;
    }

    public MapNode<T, E> getNextNode() {
        return nextNode;
    }
}
