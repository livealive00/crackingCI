package com.psh.crackingCI.ch10;

import java.util.Arrays;

/**
 * Created by Naver on 2018. 6. 17..
 */
public class P00 {
	public static void main(String[] args) {
		int[] a = {85, 10, 44, 2,  67, 21};

		System.out.println(Arrays.toString(bubbleSort(a)));
		System.out.println(Arrays.toString(selectionSort(a)));
		System.out.println(Arrays.toString(mergeSort(a)));
	}

	public static int[] mergeSort(int[] arr) {
		int[] a = Arrays.copyOf(arr, arr.length);
		int[] tmpArr = new int[arr.length];
		mergeSort(a, tmpArr, 0, arr.length - 1);
		return a;
	}

	public static void mergeSort(int[] a, int[] tmp, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, tmp, low, mid);
			mergeSort(a, tmp, mid+1, high);
			merge(a, tmp, low, mid, high);
		}
	}

	public static void merge(int[] a, int[] tmp, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			tmp[i] = a[i];
		}

		int tmpLeft = low;
		int tmpRight = mid+1;
		int cur = low;

		while (tmpLeft <= mid && tmpRight <= high) {
			if (tmp[tmpLeft] < tmp[tmpRight]) {
				a[cur] = tmp[tmpLeft];
				tmpLeft++;
			} else {
				a[cur] = tmp[tmpRight];
				tmpRight++;
			}
			cur++;
		}

		int leftRemaining = mid - tmpLeft;
		for (int i=0; i <= leftRemaining; i++) {
			a[cur + i] = tmp[tmpLeft + i];
		}
	}

	public static int[] bubbleSort(int[] arr) {
		int[] a = Arrays.copyOf(arr, arr.length);

		for (int lmt = a.length-1; lmt >= 0; lmt--) {
			for (int j = 0; j < lmt; j++) {
				if (a[j] > a[j+1]) {
					swap(a, j, j+1);
				}
			}
		}

		return a;
	}

	public static int[] selectionSort(int[] arr) {
		int[] a = Arrays.copyOf(arr, arr.length);

		for (int i = 0; i < a.length; i++) {
			int minIdx = -1;
			int minVal = Integer.MAX_VALUE;
			for (int j = i; j < a.length; j++) {
				if (a[j] < minVal) {
					minIdx = j;
					minVal = a[j];
				}
			}
			swap(a, i, minIdx);
		}

		return a;
	}

	public static void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
