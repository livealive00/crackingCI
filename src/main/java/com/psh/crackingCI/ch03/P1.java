package com.psh.crackingCI.ch03;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Naver on 2018. 4. 14..
 */
public class P1 {
	public static void main(String[] args) {
		MultiMyStack stack = new MultiMyStack(3);
		stack.push(0, 10);
		stack.push(1, 20);
		stack.push(2, 30);
		System.out.println(stack.pop(2));
		System.out.println(stack);
	}
}

class MultiMyStack {

	private static final int ARRAY_SIZE = 15;
	private int[] values = new int[ARRAY_SIZE];
	private int[] sizes;
	private int stackSize;

	public MultiMyStack(int stackSize) {
		this.values = new int[stackSize * ARRAY_SIZE];
		this.sizes = new int[stackSize];
		this.stackSize = stackSize;
	}

	public void push(int stackNum, int data) {
		if (isFull(stackNum)) {
			throw new RuntimeException();
		}
		sizes[stackNum]++;
		int idx = getTopIndex(stackNum);
		values[idx] = data;
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int idx = getTopIndex(stackNum);
		int val = values[idx];
		values[idx] = 0;
		sizes[stackNum]--;
		return val;
	}

	public int peek(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int idx = getTopIndex(stackNum);
		return values[idx];
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] >= ARRAY_SIZE;
	}

	private int getTopIndex(int stackNum) {
		return stackNum * ARRAY_SIZE + sizes[stackNum] - 1;
	}

	@Override
	public String toString() {
		return Arrays.toString(values);
	}
}
