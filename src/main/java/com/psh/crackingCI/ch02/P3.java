package com.psh.crackingCI.ch02;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 11..
 */
public class P3 {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);

		LinkedListNode<Integer> cur = l.getHead();
		int idx = 0;
		LinkedListNode<Integer> n = null;
		while (cur != null) {
			if (idx == 1) {
				n = cur;
				break;
			}
			idx++;
			cur = cur.getNext();
		}
		removeMiddle(n);
		System.out.println(l);
	}
	// 자신을 바로 뒤 엘리먼트롤 덮어씀
	public static void removeMiddle(LinkedListNode<Integer> n) {
		if (n == null || n.getNext() == null) {
			return;
		}
		n.setData(n.getNext().getData());
		n.setNext(n.getNext().getNext());
	}
}
