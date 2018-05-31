package com.psh.crackingCI.ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Naver on 2018. 5. 31..
 */
public class P08 {
	public static void main(String[] args) {
		System.out.println(getPerms("aabc"));
	}

	public static Map<Character, Integer> getCharCount(String str) {
		Map<Character, Integer> res = new HashMap<>();
		for (char ch : str.toCharArray()) {
			res.compute(ch, (k,v) -> v == null ? 1 : v+1);
		}
		return res;
	}

	public static List<String> getPerms(String str) {
		List<String> res = new ArrayList<>();
		getPerms(getCharCount(str), "", str.length(), res);
		return res;
	}

	public static void getPerms(Map<Character, Integer> charCnt, String prefix, int remaining, List<String> result) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}

		for (char ch : charCnt.keySet()) {
			int cnt = charCnt.get(ch);
			if (cnt > 0) {
				charCnt.put(ch, cnt - 1);
				getPerms(charCnt, prefix + ch, remaining-1, result);
				charCnt.put(ch, cnt);
			}
		}
	}
}
