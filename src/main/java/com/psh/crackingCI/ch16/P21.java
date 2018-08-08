package com.psh.crackingCI.ch16;

import static java.util.stream.Collectors.*;

import java.util.Set;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by Naver on 2018. 8. 8..
 */
public class P21 {

	public static void main(String[] args) {
		System.out.println(findDiff(new int[]{4,1,2,1,1,2}, new int[]{3,6,3,3}));
	}

	public static Pair<Integer, Integer> findDiff(int[] arr1, int[] arr2) {
		int sumA = IntStream.of(arr1).sum();
		int sumB = IntStream.of(arr2).sum();
		if ((sumA- sumB) % 2 != 0) {
			return null;
		}
		int target = (sumA - sumB) / 2;

		Set<Integer> arr1Elems = IntStream.of(arr1).boxed().collect(toSet());

		for (int i = 0; i < arr2.length; i++) {
			int a = target + arr2[i];
			if (arr1Elems.contains(a)) {
				return Pair.of(a, arr2[i]);
			}
		}

		return null;
	}
}
