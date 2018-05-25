package com.psh.crackingCI.ch08;

/**
 * Created by Naver on 2018. 5. 25..
 */
public class P03 {
	public static void main(String[] args) {
		int[] arr1 = new int[]{-40,-20,-1,1,2,3,5,7,9,12,13}; //7
		int[] arr2 = new int[]{-10,-5,2,2,2,3,4,6,9,12,13}; // 2

		System.out.println(findMagicIndex1(arr1));
		System.out.println(findMagicIndex1(arr2));

		System.out.println(findMagicIndex2(arr1));
		System.out.println(findMagicIndex2(arr2));
	}

	public static int findMagicIndex1(int[] arr) {
		return findMagicIndex1(arr, 0, arr.length - 1);
	}

	public static int findMagicIndex1(int[] arr, int start, int end) {
		if (start > end) {
			return -1;
		}

		int midIdx =  (start+end)/2;

		if (arr[midIdx] == midIdx) {
			return midIdx;

		} else if (midIdx < arr[midIdx]) {
			return findMagicIndex1(arr, start, midIdx-1);

		} else {
			return findMagicIndex1(arr, midIdx+1, end);
		}
	}

	public static int findMagicIndex2(int[] arr) {
		return findMagicIndex2(arr, 0, arr.length - 1);
	}

	private static int findMagicIndex2(int[] arr, int start, int end) {
		if (start > end) {
			return -1;
		}

		int midIdx = (start+end)/2;

		/*
		if (arr[midIdx] == midIdx) {
			return midIdx;
		}

		int leftEnd = Math.min(midIdx-1, arr[midIdx]);
		int leftVal = findMagicIndex2(arr, start, leftEnd);
		if (leftVal >= 0) {
			return leftVal;
		}

		int rightStart = Math.max(midIdx+1,arr[midIdx]);
		int rightVal = findMagicIndex2(arr,rightStart, end);
		return rightVal;
		*/

		if (arr[midIdx] == midIdx) {
			return midIdx;

		} else if (midIdx < arr[midIdx]) {
			int leftVal = findMagicIndex2(arr, start, midIdx-1);
			if (leftVal >= 0) {
				return leftVal;
			} else {
				return findMagicIndex2(arr, arr[midIdx], end);
			}

		} else {
			int rightVal = findMagicIndex2(arr, midIdx+1, end);
			if (rightVal >= 0) {
				return rightVal;
			} else {
				return findMagicIndex2(arr, start, arr[midIdx]);
			}
		}
	}
}
