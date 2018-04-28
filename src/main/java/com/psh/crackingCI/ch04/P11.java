package com.psh.crackingCI.ch04;

import java.util.Random;

import lombok.Data;

/**
 * Created by Naver on 2018. 4. 28..
 */
public class P11 {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(5);
		tree.insert(15);
		tree.insert(35);
		tree.insert(3);
		tree.insert(7);
		tree.insert(17);

		System.out.println(tree.getRandom().getValue());
		System.out.println(tree.getRandom().getValue());
		System.out.println(tree.getRandom().getValue());
		System.out.println(tree.getRandom().getValue());
		System.out.println(tree.getRandom().getValue());
	}

}

@Data
class TreeNode {
	private TreeNode left;
	private TreeNode right;
	private int value;
	private int size;

	public TreeNode(int val) {
		this.value = val;
		this.size = 1;
	}

	public void insert(int n) {
		if (n <= this.value) {
			if (this.getLeft() == null) {
				this.setLeft(new TreeNode(n));
			} else {
				this.getLeft().insert(n);
			}

		} else {
			if (this.getRight() == null) {
				this.setRight(new TreeNode(n));
			} else {
				this.getRight().insert(n);
			}
		}
		size++;
	}

	public void delete(int n) {

	}

	public TreeNode getRandom() {
		int leftSize = this.getLeft() == null ? 0 : this.getLeft().size;
		int rand = new Random().nextInt(this.size);
		if (rand < leftSize) {
			return this.getLeft().getRandom();

		} else if (rand == leftSize) {
			return this;
		} else {
			return this.getRight().getRandom();
		}
	}

	public TreeNode find(int n) {
		if (n == this.value) {
			return this;
		} else if (n < this.value) {
			return this.getLeft() != null ? this.getLeft().find(n) : null;
		} else {
			return this.getRight() != null ? this.getRight().find(n) : null;
		}
	}
}