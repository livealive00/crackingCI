package com.psh.crackingCI.ch04;

import com.psh.crackingCI.common.BinaryTreeNode;

/**
 * Created by Naver on 2018. 4. 24..
 */
public class P06 {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(10);
		BinaryTreeNode dep1_1 = new BinaryTreeNode(5);
		BinaryTreeNode dep1_2 = new BinaryTreeNode(15);
		BinaryTreeNode dep2_1 = new BinaryTreeNode(3);
		BinaryTreeNode dep2_2 = new BinaryTreeNode(7);
		BinaryTreeNode dep2_3 = new BinaryTreeNode(12);
		BinaryTreeNode dep2_4 = new BinaryTreeNode(17);
		BinaryTreeNode dep3_1 = new BinaryTreeNode(1);
		BinaryTreeNode dep4_1 = new BinaryTreeNode(2);

		root.setLeft(dep1_1);
		root.setRight(dep1_2);

		dep1_1.setLeft(dep2_1);
		dep1_1.setRight(dep2_2);
		dep1_2.setLeft(dep2_3);
		dep1_2.setRight(dep2_4);

		dep2_1.setLeft(dep3_1);

		dep3_1.setRight(dep4_1);

		// parent
		dep1_1.setParent(root);
		dep1_2.setParent(root);

		dep2_1.setParent(dep1_1);
		dep2_2.setParent(dep1_1);
		dep2_3.setParent(dep1_2);
		dep2_4.setParent(dep1_2);

		dep3_1.setParent(dep2_1);

		dep4_1.setParent(dep3_1);

		System.out.println(inorderSuccessor(dep4_1).getVal());	// 3
	}

	public static BinaryTreeNode inorderSuccessor(BinaryTreeNode n) {
		if (n.getRight() != null) { // left most of right
			return leftMost(n.getRight());
		}

		// right is null -> cur is left than p
		BinaryTreeNode p = n.getParent();
		BinaryTreeNode cur = n;
		while (p != null && p.getLeft() != cur) {
			cur = p;
			p = p.getParent();
		}
		return p;
	}

	public static BinaryTreeNode leftMost(BinaryTreeNode n) {
		if (n == null) {
			return null;
		}

		BinaryTreeNode cur = n;
		while (cur.getLeft() != null) {
			cur = n.getLeft();
		}

		return cur;
	}
}
