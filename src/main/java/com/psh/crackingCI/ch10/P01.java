package com.psh.crackingCI.ch10;

import java.util.Arrays;

/**
 * Created by Naver on 2018. 6. 14..
 */
public class P01 {
	public static void main(String[] args) {
		int[] tmpA = {1, 3, 5, 6, 8};
		int[] a = Arrays.copyOf(tmpA, 10);
		int[] tmpB = {2, 4, 7, 9};
		int[] b = Arrays.copyOf(tmpB, 6);

		sortAndMerge(a, b, 4, 3);

		System.out.println(Arrays.toString(a));
	}

	public static void sortAndMerge(int[] a, int[] b, int aLastIdx, int bLastIdx) {
		int insertIdx = aLastIdx + bLastIdx + 1;
		while (bLastIdx >= 0) {
			if (aLastIdx >= 0 && a[aLastIdx] > b[bLastIdx]) {
				a[insertIdx] = a[aLastIdx];
				aLastIdx--;
			} else {
				a[insertIdx] = b[bLastIdx];
				bLastIdx--;
			}
			insertIdx--;
		}
	}
}
