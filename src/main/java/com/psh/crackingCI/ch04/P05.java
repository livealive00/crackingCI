package com.psh.crackingCI.ch04;

import com.psh.crackingCI.common.BinaryTreeNode;

/**
 * Created by Naver on 2018. 4. 23..
 */
public class P05 {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		BinaryTreeNode dep1_1 = new BinaryTreeNode(5);
		BinaryTreeNode dep1_2 = new BinaryTreeNode(15);
		BinaryTreeNode dep2_1 = new BinaryTreeNode(2);
		BinaryTreeNode dep2_2 = new BinaryTreeNode(7);
		BinaryTreeNode dep2_3 = new BinaryTreeNode(12);
		BinaryTreeNode dep2_4 = new BinaryTreeNode(17);
		BinaryTreeNode dep3_1 = new BinaryTreeNode(1);
		BinaryTreeNode dep4_1 = new BinaryTreeNode(0);

		root.setLeft(dep1_1);
		root.setRight(dep1_2);

		dep1_1.setLeft(dep2_1);
		dep1_1.setRight(dep2_2);
		dep1_2.setLeft(dep2_3);
		dep1_2.setRight(dep2_4);

		dep2_1.setLeft(dep3_1);

		dep3_1.setLeft(dep4_1);

		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean isBST(BinaryTreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}

		if (n.getVal() < min || n.getVal() >= max) {
			return false;
		}

		if (!isBST(n.getLeft(), min, n.getVal()) || !isBST(n.getRight(), n.getVal(), max)) {
			return false;
		}

		return true;
	}

}
