package com.psh.crackingCI.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Naver on 2018. 4. 21..
 */
@ToString
public class BinaryTreeNode {
	@Setter @Getter
	private int val;

	@Setter @Getter
	private BinaryTreeNode left;

	@Setter @Getter
	private BinaryTreeNode right;

	public BinaryTreeNode(int val) {
		this.val = val;
	}
}
