package com.psh.crackingCI.ch04;

import java.util.ArrayList;
import java.util.List;

import com.psh.crackingCI.common.BinaryTreeNode;

/**
 * Created by Naver on 2018. 4. 22..
 */
public class P03 {
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(0);
		BinaryTreeNode dep1_1 = new BinaryTreeNode(1);
		BinaryTreeNode dep1_2 = new BinaryTreeNode(1);
		BinaryTreeNode dep2_1 = new BinaryTreeNode(2);
		BinaryTreeNode dep2_2 = new BinaryTreeNode(2);
		BinaryTreeNode dep2_3 = new BinaryTreeNode(2);
		BinaryTreeNode dep2_4 = new BinaryTreeNode(2);
		BinaryTreeNode dep3_1 = new BinaryTreeNode(3);

		root.setLeft(dep1_1);
		root.setRight(dep1_2);

		dep1_1.setLeft(dep2_1);
		dep1_1.setRight(dep2_2);
		dep1_2.setLeft(dep2_3);
		dep1_2.setRight(dep2_4);

		dep2_1.setLeft(dep3_1);

		System.out.println(groupByDepth(root));
	}

	private static List<List<BinaryTreeNode>> groupByDepth(BinaryTreeNode t) {

		List<List<BinaryTreeNode>> res = new ArrayList<>();
		List<BinaryTreeNode> cur = new ArrayList<>();
		if (t != null) {
			cur.add(t);
		}

		while (cur.size() > 0) {
			res.add(cur);

			List<BinaryTreeNode> parents = cur;
			cur = new ArrayList<>();

			for (BinaryTreeNode p : parents) {
				if (p.getLeft() != null) {
					cur.add(p.getLeft());
				}
				if (p.getRight() != null) {
					cur.add(p.getRight());
				}
			}
		}

		return res;
	}

}
