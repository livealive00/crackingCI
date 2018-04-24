package com.psh.crackingCI.common;

import lombok.Data;

/**
 * Created by Naver on 2018. 4. 9..
 */
@Data
public class LinkedListNode<T> {

	private T data;

	private LinkedListNode<T> prev;

	private LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

}
