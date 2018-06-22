package com.psh.crackingCI.ch10;

/**
 * Created by Naver on 2018. 6. 17..
 */
public class P04 {

	public static void main(String[] args) {
		Listy l = new Listy(new int[]{1,4,5,8,10,11,23});
		System.out.println(findIndex(l, 23));
	}

	public static int findIndex(Listy listy, int val) {
		if (val < 0) {
			return -1;
		}

		int i = 1;
		while (listy.elementAt(i) != -1 || listy.elementAt(i) > val) {
			i *= 2;
		}

		return binarySearchListy(listy, val, 0, i);
	}

	public static int binarySearchListy(Listy listy, int val, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;
		int x = listy.elementAt(mid);

		if (x == val) {
			return mid;

		} else if (x == -1 || val < x) {
			return binarySearchListy(listy, val, left, mid-1);

		} else {
			return binarySearchListy(listy, val, mid+1, right);
		}
	}

}



class Listy {
	private int[] arr;
	public Listy(int[] arr) {
		this.arr = arr;
	}

	public int elementAt(int i) {
		if (i >= 0 && i < arr.length) {
			return arr[i];
		}
		return -1;
	}

}