package com.psh.crackingCI.ch10;

/**
 * Created by Naver on 2018. 6. 16..
 */
public class P03 {

	public static void main(String[] args) {
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10};
		System.out.println(search(arr, 5, 0, arr.length -1)); //8
	}

	public static int search(int[] arr, int x, int left, int right) {
		int mid = left + right / 2;

		if (arr[mid] == x) {
			return mid;
		}
		if (left > right) {
			return -1;
		}

		if (arr[left] < arr[mid]) { // left
			if (x >= arr[left] && x < arr[mid]) {
				search(arr, x, left, mid-1);
			} else {
				search(arr, x, mid+1, right);
			}

		} else if (arr[left] > arr[mid]){	// right
			if (x >= arr[mid] && x <= arr[right]) {
				search(arr, x, mid+1, right);
			} else {
				search(arr, x, left, mid-1);
			}

		}

		return -1;
	}
}
