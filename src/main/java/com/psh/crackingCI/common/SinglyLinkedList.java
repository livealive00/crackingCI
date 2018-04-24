package com.psh.crackingCI.common;

import lombok.Data;

/**
 * Created by Naver on 2018. 4. 9..
 */
@Data
public class SinglyLinkedList<T> {

	private LinkedListNode<T> head;

	public void add(LinkedListNode<T> n) {
		if (head == null) {
			head = n;
		} else {
			LinkedListNode last = head;
			while (last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(n);
		}
	}
	public void add(T val) {
		LinkedListNode n = new LinkedListNode<T>(val);
		add(n);
	}
}
