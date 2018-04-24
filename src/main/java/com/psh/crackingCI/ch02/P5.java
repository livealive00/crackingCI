package com.psh.crackingCI.ch02;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 12..
 */
public class P5 {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
		l1.add(7);
		l1.add(1);
		l1.add(6);
		SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
		l2.add(5);
		l2.add(9);
		l2.add(2);

		System.out.println(sum(l1, l2));
	}

	public static SinglyLinkedList<Integer> sum(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
		SinglyLinkedList<Integer> res = new SinglyLinkedList<>();

		LinkedListNode<Integer> c1 = l1.getHead();
		LinkedListNode<Integer> c2 = l2.getHead();
		Integer carry = 0;
		while (c1 != null || c2 != null) {

			Integer c1Val = 0;
			Integer c2Val = 0;
			if (c1 != null) {
				c1Val = c1.getData();
				c1 = c1.getNext();
			}
			if (c2 != null) {
				c2Val = c2.getData();
				c2 = c2.getNext();
			}

			int sum = c1Val + c2Val + carry;
			if (sum >= 10) {
				res.add(sum % 10);
				carry = sum / 10;
			} else {
				res.add(sum);
				carry = 0;
			}
		}

		return res;
	}

}
