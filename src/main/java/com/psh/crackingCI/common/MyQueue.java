package com.psh.crackingCI.common;

import java.util.EmptyStackException;

/**
 * Created by Naver on 2018. 4. 14..
 */
public class MyQueue<T> {

	private static class QueueNode<T> {
		T data;
		QueueNode next;

		private QueueNode(T data) {
			this.data = data;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T data) {
		QueueNode<T> newNode = new QueueNode<>(data);
		if (last != null) {
			last.next = newNode;
		}
		last = newNode;

		if (first == null) {
			first = newNode;
		}
	}

	public T remove() {
		if (first == null) {
			throw new EmptyStackException();
		}
		T data = first.data;
		first = first.next;

		if (first == null) {
			last = null;
		}

		return data;
	}

	public T peek() {
		if (first == null) {
			throw new EmptyStackException();
		}
		return first.data;
	}

	public boolean isEmpty() {
		return last == null;
	}
}
