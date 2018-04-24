package com.psh.crackingCI.ch01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naver on 2018. 4. 3..
 */
public class P2 {

	public static void main(String[] args) {
		System.out.println(arePermutations("ABC", "BCA"));
		System.out.println(arePermutations("ABCA", "BACA"));

		System.out.println(arePermutations("ABCD", "BCDD"));
	}

	public static boolean arePermutations(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		// if they have same number of characters
		Map<Character, Integer> str1CharCnt = new HashMap<>();
		Map<Character, Integer> str2CharCnt = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char ch1 = str1.charAt(i);
			if (str1CharCnt.containsKey(ch1)) {
				str1CharCnt.put(ch1, str1CharCnt.get(ch1) + 1);
			} else {
				str1CharCnt.put(ch1, 1);
			}

			char ch2 = str2.charAt(i);
			if (str2CharCnt.containsKey(ch2)) {
				str2CharCnt.put(ch1, str2CharCnt.get(ch2) + 1);
			} else {
				str2CharCnt.put(ch2, 1);
			}
		}

		for (Character ch1 : str1CharCnt.keySet()) {
			int cnt1 = str1CharCnt.get(ch1);
			int cnt2 = str2CharCnt.getOrDefault(ch1, 0);
			if (cnt1 != cnt2) {
				return false;
			}
		}

		return true;
	}

}
