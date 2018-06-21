package com.psh.crackingCI.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Naver on 2018. 6. 17..
 */
public class P00 {
	public static void main(String[] args) {
		int[] a = {85, 10, 44, 2,  67, 21};

		System.out.println(Arrays.toString(bubbleSort(a)));
		System.out.println(Arrays.toString(selectionSort(a)));
		System.out.println(Arrays.toString(mergeSort(a)));
		System.out.println(Arrays.toString(quickSort(a)));
		System.out.println(Arrays.toString(radixSort(a)));

		System.out.println(binarySearch(quickSort(a), 21));
	}

	public static int binarySearch(int[] a, int x) {
		return binarySearch(a, x, 0, a.length-1);
	}

	public static int binarySearch(int[] a, int x, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right ) / 2;
		if (x == a[mid]) {
			return mid;
		} else if (x < a[mid]) {
			return binarySearch(a, x, left, mid-1);
		} else {
			return binarySearch(a, x, mid+1, right);
		}
	}

	public static int[] radixSort(int[] oriArr) {
		int[] arr = Arrays.copyOf(oriArr, oriArr.length);
		int n = maxDigit(arr);
		List<LinkedList<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			buckets.add(new LinkedList<>());
		}

		for (int d = 1; d <= n; d++) {
			for (int i = 0; i < arr.length; i++) {
				int bucketIdx = (arr[i] / (d*10)) % 10;
				buckets.get(bucketIdx).add(arr[i]);
			}

			int arrIdx = 0;
			for(LinkedList<Integer> bucket : buckets) {
				while (!bucket.isEmpty()) {
					arr[arrIdx] = bucket.poll();
					arrIdx++;
				}
			}
		}
		return arr;
	}

	public static int maxDigit(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int exp = 1;
		int n = 1;
		while (max >= exp * 10) {
			exp *= 10;
			n++;
		}
		return n;
	}

	public static int[] quickSort(int[] arr) {
		int[] a = Arrays.copyOf(arr, arr.length);
		quickSort(a, 0, a.length-1);
		return a;
	}

	public static void quickSort(int[] arr, int left, int right) {
		int mid = partition(arr, left, right);
		if (left < mid-1) {
			quickSort(arr, left, mid-1);
		}
		if (mid+1 < right) {
			quickSort(arr, mid+1, right);
		}
	}

	public static int partition(int[] arr, int left, int right) {
		int val = arr[(left+right)/2];

		while (left < right) {

			while (arr[left] < val) {
				left++;
			}
			while (arr[right] > val) {
				right--;
			}

			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}

		return left;
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
