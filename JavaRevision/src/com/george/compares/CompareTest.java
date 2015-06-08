package com.george.compares;

import com.george.functions.Functions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Cloud on 07/06/2015.
 */
public class CompareTest {
    public static void main(String[] args) {
        Fighter[] fighters = new Fighter[6];
        List<String> strs = Arrays.asList("Cloud", "Squall", "Zidane", "Tidus", "Tifa", "Rinoa", "Garnet", "Yuna");

        fighters[0] = new FighterImpl("Cloud", 12, 19);
        fighters[1] = new FighterImpl("Squall", 14, 17);
        fighters[2] = new FighterImpl("Zidane", 15, 25);
        fighters[3] = new FighterImpl("Tidus", 15, 22);
        fighters[4] = new FighterImpl("Tifa", 16, 17);
        fighters[5] = new FighterImpl("Aeris", 13, 25);

        Character[] a = {'y', 'i', 'b', 'w', 'l', 'o', 'l'};
        Comparator<String> comp = (s1, s2) -> {
            if (s1.length() > s2.length()) {
                return 1;
            }
            else if (s1.length() == s2.length()) {
                return 0;
            }
            else {
                return -1;
            }
        };
        strs.sort(comp);
        Functions.printList(strs);
        sort(fighters);
        Fighter stronger = TestFighterStrength.compareFighters(fighters[0], fighters[1]);
        System.out.println("Stronger: " + stronger.getName());
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi - lo <= 1) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        sort(a, aux, 0, N);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

    }
}
