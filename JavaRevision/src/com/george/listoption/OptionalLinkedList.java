package com.george.listoption;

import java.util.Optional;

/**
 * Created by Squall on 29/05/2015.
 */
public class OptionalLinkedList<T> {
    private OptionalWrapper<T> first;

    public OptionalLinkedList() {
        this.first = null;
    }

    private OptionalWrapper<T> addNode(Optional<T> value, OptionalWrapper<T> node) {
       if (first == null) {
            first = new OptionalWrapper<T>(value);
       }
       else {
           if (node != null && node.getNextNode() == null) {
               node.setNextNode(new OptionalWrapper<T>(value));
           }
           else {
               addNode(value, node.getNextNode());
           }
       }
       return node;
    }

    public void removeNode(int i) {
        OptionalWrapper<T> node = first;
        int count = 0;
        boolean foundNode = false;
        while(!foundNode) {
            OptionalWrapper<T> tempNode = node;
            node = node.getNextNode();
            count++;
            if (count == i) {
                foundNode = true;
            }
        }
    }

    public int length() {
        return length(first);
    }

    public int length(OptionalWrapper<T> node) {
        if (node == null) {
            return 0;
        }
        else {
            return 1 + length(node.getNextNode());
        }
    }

//    public int length() {
//        return length(1, first);
//    }
//
//    private int length(int n, OptionalWrapper<T> node) {
//        if (node.getNextNode() == null) {
//            return n;
//        }
//        else {
//            return length(n+1, node.getNextNode());
//        }
//    }

    public OptionalWrapper<T> addNode(Optional<T> value) {
        return addNode(value, first);
    }

    public OptionalWrapper<T> getFirst() {
        return first;
    }

    private void printList(OptionalWrapper<T> node) {
        if (node.getNextNode() == null) {
            System.out.println(node.getValue().get());
        }
        else {
            System.out.println(node.getValue().get());
            printList(node.getNextNode());
        }
    }

    public void printList() {
        printList(first);
    }


    public void reversePrint() {
        reversePrint(first);
    }

    public void reversePrint(OptionalWrapper<T> node) {
        if (node == null) {
            return;
        }
        else {
            reversePrint(node.getNextNode());
            System.out.println(node.getValue().get());
        }
    }

}
