package com.psh.crackingCI.ch02;

import java.util.HashSet;
import java.util.Set;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 9..
 */
public class P1 {

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(2);

		//removeDuplication(list);
		removeDuplicationWithoutCache(list);

		System.out.println(list);

	}

	public static void removeDuplication(SinglyLinkedList<Integer> list) {
		if (list.getHead() == null) {
			return;
		}

		LinkedListNode<Integer> prev = list.getHead();
		LinkedListNode<Integer> cur = prev.getNext();

		Set<Integer> vals = new HashSet<>();
		vals.add(prev.getData());

		while (cur != null) {
			if (vals.contains(cur.getData())) {
				prev.setNext(cur.getNext());

			} else {
				vals.add(cur.getData());
				prev = cur;
			}

			cur = cur.getNext();
		}
	}

	public static void removeDuplicationWithoutCache(SinglyLinkedList<Integer> list) {
		if (list.getHead() == null) {
			return;
		}

		LinkedListNode<Integer> cur = list.getHead();

		while (cur != null) {
			int val = cur.getData();

			LinkedListNode<Integer> prevRunner = cur;
			LinkedListNode<Integer> runner = cur.getNext();
			while (runner != null) {
				if (val == runner.getData()) {
					prevRunner.setNext(runner.getNext());
				} else {
					prevRunner = runner;
				}

				runner = runner.getNext();
			}

			cur = cur.getNext();
		}
	}

}
