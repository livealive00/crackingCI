package com.psh.crackingCI.ch02;

import java.util.Stack;

import com.psh.crackingCI.common.LinkedListNode;
import com.psh.crackingCI.common.SinglyLinkedList;

/**
 * Created by Naver on 2018. 4. 12..
 */
public class P6 {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(2);
		l1.add(1);
		System.out.println(isPalindrome(l1));
		System.out.println(isPalindromeUsingStack(l1));

		SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		l2.add(4);
		l2.add(1);
		System.out.println(isPalindrome(l2));
		System.out.println(isPalindromeUsingStack(l2));
	}

	public static boolean isPalindrome(SinglyLinkedList<Integer> l) {
		if (l == null) {
			return false;
		}

		LinkedListNode<Integer> cur = l.getHead();
		LinkedListNode<Integer> rev = null;
		while (cur != null) {
			LinkedListNode<Integer> n = new LinkedListNode<>(cur.getData());
			n.setNext(rev);
			rev = n;
			cur = cur.getNext();
		}

		cur = l.getHead();
		while (cur != null) {
			if (cur.getData() != rev.getData().intValue()) {
				return false;
			}
			cur = cur.getNext();
			rev = rev.getNext();
		}

		return true;
	}

	public static boolean isPalindromeUsingStack(SinglyLinkedList<Integer> l ) {
		LinkedListNode<Integer> cur = l.getHead();
		LinkedListNode<Integer> fast = l.getHead();
		Stack<Integer> stack = new Stack<>();
		while (fast != null && fast.getNext() != null) {
			stack.push(cur.getData());
			cur = cur.getNext();
			fast = fast.getNext().getNext();
		}

		if (fast != null) {
			cur = cur.getNext();
		}

		while (!stack.isEmpty()) {
			int elem = stack.pop();
			if (elem != cur.getData()) {
				return false;
			}
			cur = cur.getNext();
		}

		return true;
	}
}
