package com.psh.crackingCI.ch08;

import java.util.Stack;

/**
 * Created by Naver on 2018. 5. 28..
 */
public class P06 {

	public static void main(String[] args) {
		hanoi(3);
	}

	public static void hanoi(int numRings) {
		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		Stack<Integer> c = new Stack<>();

		for (int i = numRings; i >= 1; i--) {
			a.push(i);
		}

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		hanoi(a, c, b, numRings);

		System.out.println("=== result ===");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

	public static void hanoi(Stack<Integer> from, Stack<Integer> to, Stack<Integer> tmp, int movingCnt) {
		if (movingCnt == 1) {
			to.push(from.pop());
			return;
		}

		hanoi(from, tmp, to, movingCnt-1);
		to.push(from.pop());
		hanoi(tmp, to, from, movingCnt-1);
	}
}
