package com.george.listoption;

import java.util.Optional;

/**
 * Created by Squall on 29/05/2015.
 */
public class OptionalLinkedListTests {
    public static void main(String[] args) {
        OptionalLinkedList<String> list = new OptionalLinkedList<String>();
        list.addNode(Optional.of("Hello"));
        list.addNode(Optional.of("Good Day"));
        list.addNode(Optional.of("Godzilla"));
        list.addNode(Optional.of("Arrgh!"));
        System.out.println(list.length());
//        list.removeNode(1);
        list.printList();
        list.reversePrint();
    }
}
