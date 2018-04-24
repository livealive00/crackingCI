package com.psh.crackingCI.ch02;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 13..
 */
public class P8 {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(1);
		list.add(2);

		LinkedListNode<Integer> n3 = new LinkedListNode<>(3);
		LinkedListNode<Integer> n4 = new LinkedListNode<>(4);
		LinkedListNode<Integer> n5 = new LinkedListNode<>(5);

		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n3);

		list.add(n3);

		System.out.println(findBeginingNodeData(list));
	}

	public static Integer findBeginingNodeData(SinglyLinkedList<Integer> list) {
		if (list == null || list.getHead() == null) {
			return null;
		}

		// 1. 해시맵으로 털면 바로 나옴 O(n) 공간사용
		// 2. fast slow 두개의 포인터를 이용
		LinkedListNode<Integer> slow = list.getHead();
		LinkedListNode<Integer> fast = list.getHead();
		int k = 0;
		while (slow != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			k++;

			if (slow == fast) {
				break;
			}
		}

		slow = list.getHead();
		while (slow != null) {
			if (slow == fast) {
				break;
			}

			slow = slow.getNext();
			fast = fast.getNext();
		}

		return slow.getData();
	}
}
