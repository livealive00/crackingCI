package com.psh.crackingCI.ch02;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 12..
 */
public class P4 {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
		l.add(3);
		l.add(6);
		l.add(1);
		l.add(5);
		l.add(20);
		l.add(3);
		l.add(2);

		split(l, 5);
		System.out.println(l);
	}

	public static void split(SinglyLinkedList<Integer> l, int x) {
		if (l.getHead() == null) {
			return;
		}

		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> cur = l.getHead();
		LinkedListNode<Integer> newHead = new LinkedListNode<>(x);
		LinkedListNode<Integer> newCur = newHead;

		while (cur != null) {
			LinkedListNode<Integer> next = cur.getNext();
			if (cur.getData() < x) {	// 원소가 그보다 작으면 그대로 진행
				prev = cur;

			} else {	// 원소가 x 보다 크거나 같으면, 기존 노드는 리스트에서 삭제하고 x 로 시작하는 노드 뒤에 삽입
				// del
				if (prev != null) {	// cur is head
					prev.setNext(cur.getNext());
				}

				cur.setNext(null);
				newCur.setNext(cur);
				newCur = cur;
			}

			cur = next;
		}

		if (prev == null) {
			l.setHead(newHead);
		} else {
			prev.setNext(newHead);
		}
	}
}
