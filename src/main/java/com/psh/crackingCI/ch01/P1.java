package com.psh.crackingCI.ch01;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naver on 2018. 4. 3..
 */
public class P1 {

	public static void main(String[] args) {
		System.out.println(hasDupChars("AASS"));
		System.out.println(hasDupChars("ASDF"));
	}

	public static boolean hasDupChars(String str) {
		Set<Character> checked = new HashSet<Character>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (checked.contains(c)) {
				return true;
			}
			checked.add(c);
		}

		return false;

	}

}
