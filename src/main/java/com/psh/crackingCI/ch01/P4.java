package com.psh.crackingCI.ch01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naver on 2018. 4. 4..
 */
public class P4 {
	public static void main(String[] args) {
		System.out.println(isPalindromePermutation("tact coa"));
		System.out.println(isPalindromePermutation("tact cob"));
	}

	public static boolean isPalindromePermutation(String str) {

		Map<Character, Integer> chCnt = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ' ') {
				continue;
			}

			if (chCnt.containsKey(ch)) {
				chCnt.put(ch, chCnt.get(ch) + 1);
			} else {
				chCnt.put(ch, 1);
			}
		}

		boolean oddChar = false;
		for (char ch : chCnt.keySet()) {
			int cnt = chCnt.get(ch);
			if (cnt % 2 != 0) {
				if (oddChar) {
					return false;
				}
				oddChar = true;
			}
		}
		return true;
	}
}
