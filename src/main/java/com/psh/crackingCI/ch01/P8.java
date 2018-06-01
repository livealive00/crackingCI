package com.psh.crackingCI.ch01;

import com.psh.crackingCI.utils.Printer;

/**
 * Created by Naver on 2018. 4. 8..
 */
public class P8 {
	public static void main(String[] args) {
		int[][] mat = new int[][]{
			{1,0,3},
			{2,3,4},
			{0,7,9},
			{10,11,12}
		};

		replaceZeros(mat);

		Printer.printMatrix(mat);
	}

	public static void replaceZeros(int[][] mat) {
		if (mat == null || mat.length == 0) {
			return;
		}

		int rowLen = mat.length;
		int colLen = mat[0].length;

		boolean[] rows = new boolean[rowLen];
		boolean[] cols = new boolean[colLen];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length ; j++) {
				if (mat[i][j] == 0) {
					if (!rows[i]) {
						rows[i] = true;
					}

					if (!cols[j]) {
						cols[j] = true;
					}
				}
			}
		}

		for (int i = 0; i < rows.length; i++) {
			if (rows[i]) {
				for (int c = 0; c < colLen; c++) {
					mat[i][c] = 0;
				}
			}
		}

		for (int i = 0; i < cols.length; i++) {
			if (cols[i]) {
				for (int r = 0; r < rowLen; r++) {
					mat[r][i] = 0;
				}
			}
		}
	}
}
