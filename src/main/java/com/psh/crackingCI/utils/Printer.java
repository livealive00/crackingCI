package com.psh.crackingCI.utils;

/**
 * Created by Naver on 2018. 6. 1..
 */
public class Printer {

	public static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
