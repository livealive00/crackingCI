package com.psh.crackingCI.ch07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sun.tools.classfile.ConstantPool;

/**
 * Created by Naver on 2018. 5. 19..
 */
public class P09 {
	public static void main(String[] args) {
		CircularArray<Integer> arr = new CircularArray<Integer>(4);
		arr.set(0, 0);
		arr.set(1, 1);
		arr.set(2, 2);
		arr.set(-1, 3);

		System.out.println(arr);
		arr.rotate(-1);
		System.out.println(arr.get(1));

		System.out.println("----");
		for (Integer i : arr) {
			System.out.println(i);
		}
	}
}


class CircularArray<T> implements Iterable<T> {
	T[] items;

	int head = 0;

	public CircularArray(int size) {
		this.items = (T[]) new Object[size];
	}

	public void rotate(int shiftRight) {
		this.head = convert(shiftRight);
	}

	public int convert(int idx) {
		int convIdx = (head + idx) % items.length;
		if (convIdx < 0) {
			convIdx = (items.length + convIdx);
		}
		return convIdx;
	}

	public void set(int i, T item) {
		this.items[convert(i)] = item;
	}

	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new UnsupportedOperationException();
		}
		return this.items[convert(i)];
	}

	public String toString() {
		return Arrays.toString(items);
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator(this);
	}

	private class CircularArrayIterator implements Iterator<T> {

		private int _current = -1;
		private T[] _items;

		public CircularArrayIterator(CircularArray<T> array) {
			_items = array.items;
		}

		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}

		@Override
		public T next() {
			_current++;
			return _items[convert(_current)];
		}
	}
}