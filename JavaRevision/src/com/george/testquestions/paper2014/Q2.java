package com.george.testquestions.paper2014;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Cloud on 06/06/2015.
 */
public class Q2 {
    public static void main(String[] args) {
        List<Character> l1 = Arrays.asList('1');
        List<Character> l2 = Arrays.asList('1', '+', '2');
        List<Character> l3 = Arrays.asList('+', '2');
        System.out.println(isValidExpression(l1));
        System.out.println(isValidExpression(l2));
        System.out.println(isValidExpression(l3));
    }

    public static boolean isValidExpression(List<Character> list) {
        boolean result = false;
        if (list == null || list.isEmpty()) return result;
        if (list.size() == 1) {
            result = Character.isDigit(list.get(0));
        }
        else {
            if ((Character.isDigit(list.get(0))) && (list.get(1).equals('-') || list.get(1).equals('+'))) {
                LinkedList<Character> temp = new LinkedList<Character>(list);
                temp.remove();
                temp.remove();
                result = isValidExpression(temp);
            }
        }
        return result;
    }
}
