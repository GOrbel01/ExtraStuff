package com.george.compares;

/**
 * Created by Squall on 07/06/2015.
 */
public class FighterImpl implements Fighter, Comparable<Fighter> {

    private String name;
    private int attack;
    private int attrPts;

    public FighterImpl(String name, int attack, int attr) {
        this.name = name;
        this.attack = attack;
        this.attrPts = attr;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getAttrPts() {
        return attrPts;
    }

    @Override
    public int compareTo(Fighter f) {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
    }
}
