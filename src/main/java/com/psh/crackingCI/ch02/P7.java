package com.psh.crackingCI.ch02;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 13..
 */
public class P7 {

	public static void main(String[] args) {
		LinkedListNode<Integer> sameElem = new LinkedListNode<>(100);
		sameElem.setNext(new LinkedListNode<>(200));
		SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
		l1.add(1);
		l1.add(sameElem);

		SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
		l2.add(11);
		l2.add(12);
		l2.add(sameElem);

		System.out.println(intersect(l1, l2));
		System.out.println(intersectFaster(l1, l2));
	}

	public static LinkedListNode<Integer> intersect(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
		LinkedListNode<Integer> res = null;
		if (l1 == null || l2 == null) {
			return res;
		}

		LinkedListNode<Integer> c1 = l1.getHead();
		while (c1 != null) {
			LinkedListNode<Integer> c2 = l2.getHead();
			boolean found = false;
			while (c2 != null) {
				if (c1 == c2) {
					res = c1;
					found = true;
					break;
				}
				c2 = c2.getNext();
			}
			if (found) {
				break;
			}
			c1 = c1.getNext();
		}

		return res;
	}

	public static LinkedListNode<Integer> intersectFaster(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
		if (l1 == null || l2 == null || l1.getHead() == null || l2.getHead() == null) {
			return null;
		}

		LinkedListNode<Integer> c1 = l1.getHead();
		int len1 = 0;
		while (c1 != null && c1.getNext() != null) {
			len1++;
			c1 = c1.getNext();
		}

		LinkedListNode<Integer> c2 = l2.getHead();
		int len2 = 0;
		while (c2 != null && c2.getNext() != null) {
			len2++;
			c2 = c2.getNext();
		}

		c1 = l1.getHead();
		c2 = l2.getHead();
		if (len1 > len2) {
			int dist = len1 - len2;
			return findSameElem(c1, c2, dist);

		} else if (len2 > len1){
			int dist = len2 - len1;
			return findSameElem(c2, c1, dist);

		}
		return null;
	}

	public static LinkedListNode<Integer> findSameElem(LinkedListNode<Integer> longer, LinkedListNode<Integer> shorter, int dist) {
		for (int i = 0; i < dist; i++) {
			longer = longer.getNext();
		}

		while (longer != null) {
			if (longer == shorter) {
				return longer;
			}
			longer = longer.getNext();
			shorter = shorter.getNext();
		}


		return null;
	}

}
