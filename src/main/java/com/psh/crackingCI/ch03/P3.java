package com.psh.crackingCI.ch03;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Created by Naver on 2018. 4. 16..
 */
public class P3 {
	public static void main(String[] args) {
		SetOfStack s = new SetOfStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		System.out.println(s);

		s.pop();
		s.pop();
		System.out.println(s);
	}


}

class SetOfStack {
	List<Stack<Integer>> stacks = new ArrayList<>();
	final int SIZE_STACK = 2;

	public int pop() {
		Stack<Integer> s = getLastStack();
		int val = s.pop();
		if (s.isEmpty()) {
			stacks.remove(stacks.size() - 1);
		}
		return val;
	}

	public void push(int i) {
		if (isEmpty()) {
			stacks.add(new Stack<>());
		}

		Stack<Integer> lastStack = getLastStack();
		if (lastStack.size() == SIZE_STACK) {
			stacks.add(new Stack<>());
		}

		lastStack = getLastStack();
		lastStack.push(i);
	}

	public Stack<Integer> getLastStack() {
		if (stacks.isEmpty()) {
			throw new EmptyStackException();
		}
		return stacks.get(stacks.size()-1);
	}

	public boolean isEmpty() {
		return stacks.isEmpty();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Stack<Integer> s : stacks) {
			sb.append(s.toString());
			sb.append(",");
		}
		return sb.toString();
	}
}
