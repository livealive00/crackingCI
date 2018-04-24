package com.psh.crackingCI.ch02;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 11..
 */
public class P2 {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println(getElemFromRearLen(list, 2));
		System.out.println(getElemFromRearIter(list, 2));
		System.out.println(getElemFromRearLen(list, 2));
	}

	public static Integer getElemFromRearLen(SinglyLinkedList<Integer> list, int k) {

		LinkedListNode<Integer> cur = list.getHead();
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.getNext();
		}

		cur = list.getHead();
		int tarIdx = len - k;
		while (cur != null && len > 0) {
			tarIdx--;
			if (tarIdx == 0) {
				return cur.getData();
			}
			cur = cur.getNext();
		}

		return null;
	}

	public static Integer getElemFromRearIter(SinglyLinkedList<Integer> list, int k) {

		LinkedListNode<Integer> cur = list.getHead();
		int i = 0;
		LinkedListNode<Integer> res = null;
		while (cur != null) {
			if (i == k) {
				res = list.getHead();
			} else if (i > k) {
				res = res.getNext();
			}
			i++;
			cur = cur.getNext();
		}

		return (res == null) ? null : res.getData();
	}

	public static Integer getElemFromRearRecur(SinglyLinkedList<Integer> list, int k) {
		if (list == null || list.getHead() == null) {
			return null;
		}

		return recur(list.getHead(), 0, k).res;
	}

	public static RecurResult recur(LinkedListNode<Integer> n, int idx, int k) {
		if (n.getNext() != null) {
			RecurResult r =  recur(n.getNext(), idx+1, k);
			if (r.idxFromRear == k) {
				return r;
			} else {
				return new RecurResult(r.idxFromRear + 1, n.getData());
			}
		} else {
			return new RecurResult(0, n.getData());
		}
	}

	static class RecurResult {
		public RecurResult(Integer idxFromRear, Integer res) {
			this.idxFromRear = idxFromRear;
			this.res = res;
		}

		private Integer idxFromRear = null;
		private Integer res = null;
	}
}
