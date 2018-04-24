package com.psh.crackingCI.ch01;

/**
 * Created by Naver on 2018. 4. 6..
 */
public class P7 {
	public static void main(String[] args) {
		int [][] twoByTwo = new int[][]{
			{1,2},
			{3,4}
		};

		printMatrix(rotate(twoByTwo));
		System.out.println("----");
		printMatrix(rotateInPlace(twoByTwo));

		int[][] threeByThree = new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};

		System.out.println("=========");

		printMatrix(rotate(threeByThree));
		System.out.println("----");
		printMatrix(rotateInPlace(threeByThree));

	}

	public static int[][] rotate(int[][] mat) {
		int len  = mat.length;
		int[][] res = new int[len][len];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				res[j][len - 1 -i] = mat[i][j];
			}
		}
		return res;
	}

	public static int[][] rotateInPlace(int[][] mat) {
		int len = mat.length;
		int xMidIdx = len / 2 + len % 2;
		int yMidIdx = len / 2;

		for (int i = 0; i < xMidIdx; i++) {
			for (int j = 0; j < yMidIdx; j++) {
				int cur = mat[i][j];
				mat[i][j] = mat[len - 1 -j][i] ;
				mat[len - 1 -j][i] = mat[len - 1 - i][len -1 - j];
				mat[len - 1 - i][len -1 -j] = mat[j][len -1 -i];
				mat[j][len -1 -i] = cur;
			}
		}

		return mat;
	}

	public static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
