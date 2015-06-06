package com.george.testquestions.paper2014;

/**
 * Created by Cloud on 06/06/2015.
 */

import java.util.Map;
 
public class MultiSetMap implements MultiSet {

	private Map<String, Integer> map;
	public int size() {
		int total = 0;
		for (int x : map.values()) {
			total += x;
		}
		return total;
	}

    public boolean contains(String s) {
        return map.get(s) != null;
    }

    public int occurrences(String s) {
        return map.get(s);
    }

    public void add(String s) {
        if (map.get(s) == null) {
            map.put(s, 1);
        }
        else {
            map.put(s, map.get(s)+1);
        }
    }

    public boolean remove(String s) {
        if (!(contains(s))) {
            return false;
        }
        else {
            if (occurrences(s) == 1) {
                map.remove(s);
                return true;
            }
            else {
                map.put(s, occurrences(s)-1);
                return true;
            }
        }
    }
}
