package com.psh.crackingCI.ch03;

import java.util.Stack;

/**
 * Created by Naver on 2018. 4. 17..
 */
public class P5 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(7);
		stack.push(3);
		stack.push(6);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(5);

		sort(stack);

		System.out.println(stack);
	}

	public static void sort(Stack<Integer> sorted) {
		Stack<Integer> reversed = new Stack<>();

		while (!sorted.isEmpty()) {
			int val = sorted.pop();
			while (!reversed.isEmpty() && reversed.peek() > val) {
				sorted.push(reversed.pop());
			}
			reversed.push(val);
		}

		while (!reversed.isEmpty()) {
			sorted.push(reversed.pop());
		}

	}
}
