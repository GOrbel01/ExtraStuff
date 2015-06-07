package com.george.compares;

import java.io.Serializable;

/**
 * Created by Squall on 07/06/2015.
 */
public interface Fighter extends Comparable<Fighter> {
    String getName();
    int getAttack();
    int getAttrPts();
}
