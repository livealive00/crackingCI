package com.psh.crackingCI.ch08;

import java.util.Stack;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by Naver on 2018. 6. 3..
 */
public class P12 {

	public static void main(String[] args) {
		System.out.println(countWaysForQueens(4));
	}

	public static int countWaysForQueens(int n) {
		Stack<Pair<Integer, Integer>> stack = new Stack<>();
		return countWaysForQueens(n, 0, stack);
	}

	public static int countWaysForQueens(int n, int x, Stack<Pair<Integer, Integer>> paths) {
		if (x >= n) {
			return 1;
		}

		int ways = 0;
		for (int y = 0; y < n; y++) {
			if (checkValid(paths, x, y)) {
				paths.push(Pair.of(x, y ));
				ways += countWaysForQueens(n, x+1, paths);
				paths.pop();
			}
		}
		return ways;
	}

	public static boolean checkValid(Stack<Pair<Integer, Integer>> paths, int x, int y) {
		for (Pair<Integer, Integer> p : paths) {
			if (x == p.getLeft() || y == p.getRight()) {
				return false;
			}
			if (Math.abs(y - p.getRight()) == x - p.getLeft()) {
				return false;
			}
		}

		return true;
	}
}
