package com.psh.crackingCI.ch08;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Created by Naver on 2018. 5. 26..
 */
public class P04 {

	public static void main(String[] args) {
		System.out.println(getSubsets(Lists.newArrayList(1,2,3)));
	}

	public static List<List<Integer>> getSubsets(List<Integer> set) {
		if (set.isEmpty()) {
			return Lists.newArrayList();
		}
		List<List<Integer>> res = new ArrayList<>();
		getSubsets(set, 0, new ArrayList<>(), res);
		return res;
	}

	public static void getSubsets(List<Integer> set, int i, List<Integer> base, List<List<Integer>> result) {
		if (i == set.size()) {
			result.add(base);
			return;
		}
		List<Integer> added = Lists.newArrayList(base);
		added.add(set.get(i));
		getSubsets(set, i+1, added,result);
		getSubsets(set, i+1, base, result);
	}
}
