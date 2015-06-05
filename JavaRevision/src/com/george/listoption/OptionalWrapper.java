package com.george.listoption;

import java.util.Optional;

/**
 * Created by Squall on 29/05/2015.
 */
public class OptionalWrapper<T> {
    private Optional<T> value;
    private OptionalWrapper<T> nextNode;

    public OptionalWrapper(Optional<T> value) {
        this.value = value;
        this.nextNode = null;
    }

    public Optional<T> getValue() {
        return value;
    }

    public OptionalWrapper<T> getNextNode() {
        return nextNode;
    }

    public void setValue(Optional<T> value) {

    }

    public void setNextNode(OptionalWrapper<T> next) {
        this.nextNode = next;
    }
}
