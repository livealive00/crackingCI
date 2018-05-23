package com.psh.crackingCI.ch08;

import java.util.Map;

/**
 * Created by Naver on 2018. 5. 23..
 */
public class P01 {
	public static void main(String[] args) {
		System.out.println(countWays(10));
		System.out.println(countWaysMemo(10, new int[11]));
		System.out.println(countWaysMemo2(10, new int[11]));
	}

	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n-1) + countWays(n-2) + countWays(n-3);
		}
	}

	public static int countWaysMemo2(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > 0) {
			return memo[n];
		} else {
			memo[n] =  countWays(n-1) + countWays(n-2) + countWays(n-3);
			return memo[n];
		}
	}

	public static int countWaysMemo(int n, int[] memo) {
		if (n == 0) {
			return 1;
		}

		int count = 0;
		if (n >= 1) {
			memo[n-1] = countWaysMemo(n-1, memo);
			count += memo[n-1];
		}
		if (n >= 2) {
			memo[n-2] = countWaysMemo(n-2, memo);
			count += memo[n-2];
		}
		if (n >= 3) {
			memo[n-3] = countWaysMemo(n-3, memo);
			count += memo[n-3];
		}

		return count;
	}
}
