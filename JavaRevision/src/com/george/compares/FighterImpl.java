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
        int callerPoints = this.attack + this.attrPts;
        int paramPoints = f.getAttack() + f.getAttrPts();
        if (callerPoints < paramPoints) {
            return -1;
        }
        else if (callerPoints == paramPoints) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        FighterImpl fighter = (FighterImpl) obj;

        return !(name != null ? !name.equals(fighter.name) : fighter.name != null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result;
        return result;
    }
}
