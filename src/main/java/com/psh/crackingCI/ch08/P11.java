package com.psh.crackingCI.ch08;

import com.psh.crackingCI.utils.Printer;

/**
 * Created by Naver on 2018. 6. 2..
 */
public class P11 {

	public static void main(String[] args) {
		System.out.println(makeChange(100));
	}

	public static int makeChange(int n) {
		// 25, 10, 5, 1
		int[] denoms = new int[]{25, 10, 5, 1};
		int[][] cache = new int[n+1][denoms.length];
		return makeChange(n, denoms, 0, cache);
	}

	public static int makeChange(int n, int[] denoms, int idx, int[][] cache) {
		if (n == 0) {
			return 1;
		}

		if (idx >= denoms.length) {
			return 0;
		}

		if (cache[n][idx] > 0) {
			return cache[n][idx];
		}

		int denom = denoms[idx];
		int ways = 0;
		for (int i = 0 ; i * denom <= n; i++) {
			ways += makeChange(n - denom * i, denoms, idx+1, cache);
		}
		cache[n][idx] = ways;
		return ways;
	}
}
