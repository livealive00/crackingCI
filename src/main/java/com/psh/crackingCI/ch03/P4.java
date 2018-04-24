package com.psh.crackingCI.ch03;

import java.util.Stack;

/**
 * Created by Naver on 2018. 4. 17..
 */
public class P4 {
	public static void main(String[] args) {

	}
}

class MyQueueUsingStacks {
	Stack<Integer> oldStack = new Stack<>();
	Stack<Integer> newStack = new Stack<>();


	public void add(int i) {
		newStack.add(i);
	}

	public int remove() {
		shiftStack();
		return oldStack.pop();
	}

	public int peeak() {
		shiftStack();
		return oldStack.peek();
	}

	public void shiftStack() {
		if (!newStack.isEmpty()) {
			while (!oldStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
	}

	public boolean isEmpty() {
		return oldStack.isEmpty() && newStack.isEmpty();
	}
}