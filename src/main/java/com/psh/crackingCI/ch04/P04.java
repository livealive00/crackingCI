package com.psh.crackingCI.ch04;

import com.psh.crackingCI.common.BinaryTreeNode;

/**
 * Created by Naver on 2018. 4. 23..
 */
public class P04 {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(0);
		BinaryTreeNode dep1_1 = new BinaryTreeNode(1);
		BinaryTreeNode dep1_2 = new BinaryTreeNode(1);
		BinaryTreeNode dep2_1 = new BinaryTreeNode(2);
		BinaryTreeNode dep2_2 = new BinaryTreeNode(2);
		BinaryTreeNode dep2_3 = new BinaryTreeNode(2);
		BinaryTreeNode dep2_4 = new BinaryTreeNode(2);
		BinaryTreeNode dep3_1 = new BinaryTreeNode(3);
		BinaryTreeNode dep4_1 = new BinaryTreeNode(4);

		root.setLeft(dep1_1);
		root.setRight(dep1_2);

		dep1_1.setLeft(dep2_1);
		dep1_1.setRight(dep2_2);
		dep1_2.setLeft(dep2_3);
		dep1_2.setRight(dep2_4);

		dep2_1.setLeft(dep3_1);

		dep3_1.setLeft(dep4_1);

		System.out.println(isBalancedTree(root));
	}

	public static boolean isBalancedTree(BinaryTreeNode root) {
		if (root == null) {
			return false;
		}

		int leftDepth = root.getLeft() == null ? 0 : depthOfTree(root.getLeft(), 0);
		int rightDepth = root.getRight() == null ? 0 : depthOfTree(root.getRight(), 0);

		return Math.abs(leftDepth - rightDepth) <= 1;

	}

	public static int depthOfTree(BinaryTreeNode n, int parentDepth) {

		int leftDepth = n.getLeft() == null ? parentDepth : depthOfTree(n.getLeft(), parentDepth + 1);
		int rightDepth = n.getRight() == null ? parentDepth : depthOfTree(n.getRight(), parentDepth + 1);

		return Math.max(leftDepth, rightDepth);
	}
}
