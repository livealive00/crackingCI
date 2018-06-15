package com.psh.crackingCI.ch10;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Naver on 2018. 6. 15..
 */
public class P02 {

	public static void main(String[] args) {
		String[] arr = new String[] { "acre", "race", "pjoo","maxi" ,"pojo",  "naxi", "care"};
		sortAnagram(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sortAnagram(String[] arr) {
		Arrays.sort(arr, Comparator.comparing(P02::sorted));
		//(a, b) -> sorted(a).compareTo(sorted(b))
	}

	public static String sorted(String a) {
		char[] charArr = a.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}
}
