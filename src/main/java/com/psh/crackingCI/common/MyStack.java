package com.psh.crackingCI.common;

import java.util.EmptyStackException;

/**
 * Created by Naver on 2018. 4. 14..
 */
public class MyStack<T> {
	private static class StackNode<T> {
		T data;
		StackNode next;

		private StackNode(T data) {
			this.data = data;
		}
	}

	public StackNode<T> top = null;

	public void push(T data) {
		StackNode<T> newNode = new StackNode<>(data);
		newNode.next = top;
		top = newNode;
	}

	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T data = top.data;
		top = top.next;
		return data;

	}

	public boolean isEmpty() {
		return top == null;
	}

	public T peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

}
