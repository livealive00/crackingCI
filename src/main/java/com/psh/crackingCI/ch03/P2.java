package com.psh.crackingCI.ch03;

import java.util.EmptyStackException;

import com.psh.crackingCI.common.MyStack;

/**
 * Created by Naver on 2018. 4. 15..
 */
public class P2 {
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();

		stack.push(5);
		stack.push(6);
		stack.push(3);
		stack.push(7);

		System.out.println(stack.pop());
		System.out.println(stack.min());

		System.out.println(stack.pop());
		System.out.println(stack.min());
	}
}

class StackWithMin extends MyStack<Integer> {
	MyStack<Integer> minStack = new MyStack<>();

	@Override
	public void push(Integer i) {
		super.push(i);
		if (minStack.isEmpty()) {
			minStack.push(i);
		} else {
			if (i <= min()) {
				minStack.push(i);
			}
		}
	}

	@Override
	public Integer pop() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}

		if (peek() <= min()) {
			minStack.pop();
		}

		return super.pop();
	}

	public Integer min() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}
		return minStack.peek();
	}
}