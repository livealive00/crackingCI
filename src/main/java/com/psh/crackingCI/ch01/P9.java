package com.psh.crackingCI.ch01;

/**
 * Created by Naver on 2018. 4. 8..
 */
public class P9 {

	public static void main(String[] args) {
		System.out.println(isRoateString("waterbottle", "erbottlewat"));
		System.out.println(isRoateString("water", "torwa"));

	}

	public static boolean isRoateString(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		return (s1 + s1).contains(s2);
	}

}
