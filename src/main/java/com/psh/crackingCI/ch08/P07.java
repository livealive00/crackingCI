package com.psh.crackingCI.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Created by Naver on 2018. 5. 29..
 */
public class P07 {

	public static void main(String[] args) {
		System.out.println(getPerms("abc"));
	}

	public static List<String> getPerms(String str) {
		List<String> res = new ArrayList<>();
		Set<Character> strSet = new HashSet<>();
		for (char ch : str.toCharArray()) {
			strSet.add(ch);
		}
		getPerms(strSet, "", res);

		return res;
	}

	public static void getPerms(Set<Character> str, String tmp, List<String> res) {
		if (str.isEmpty()) {
			res.add(tmp);
			return;
		}

		for (Character ch : str) {
			Set<Character> newSet = new HashSet<>(str);
			newSet.remove(ch);
			getPerms(newSet, tmp + ch, res);
		}
	}
}
