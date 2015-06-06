package com.george.testquestions;

/**
 * Created by Cloud on 05/06/2015.
 */
public class Q5 {
	public static void main(String[] args) {
		Q5 tq5 = new Q5();
		tq5.recString("abcde");
	}
	
	public void recString(String str) {
		System.out.println(str);
		if (str.length() > 1) {
			recString(str.substring(0, str.length()-1));
		}
        System.out.println(str);
	}
}
