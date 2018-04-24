package com.psh.crackingCI.ch04;

import com.psh.crackingCI.common.BinaryTreeNode;

/**
 * Created by Naver on 2018. 4. 21..
 */
public class P02 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(getBinarySearchTree(arr));
	}

	public static BinaryTreeNode getBinarySearchTree(int[] arr) {
		return getNode(arr, 0, arr.length-1);
	}

	public static BinaryTreeNode getNode(int[] arr, int start, int end) {
		int mid = start + (end - start) / 2;
		BinaryTreeNode node = new BinaryTreeNode(arr[mid]);
		if (start < mid) {
			node.setLeft(getNode(arr, start, mid - 1));
		}
		if (mid < end) {
			node.setRight(getNode(arr, mid + 1, end));
		}
		return node;
	}
}
