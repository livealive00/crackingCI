package com.psh.crackingCI.ch08;

import org.apache.commons.lang3.tuple.Pair;

import com.psh.crackingCI.utils.Printer;

/**
 * Created by Naver on 2018. 6. 1..
 */
public class P10 {

	public static void main(String[] args) {
		int[][] screen = new int[][] {
			{1,2,1,3},
			{1,2,2,3},
			{1,1,2,3},
			{1,3,3,3}
		};

		fillPainting(screen, 1,2, 9); // 2

		Printer.printMatrix(screen);
	}

	public static void fillPainting(int[][] screen, int i, int j, int color) {
		if (screen.length < 1) {
			return;
		}

		if (screen[0].length < 1) {
			return;
		}

		int oriColor = screen[i][j];
		fillPainting(screen, i, j, oriColor, color);
	}

	public static void fillPainting(int[][] screen, int i, int j, int oriColor, int newColor) {

		if (i < 0 || j < 0 || i >= screen.length || j >= screen[0].length) {
			return;
		}

		if (screen[i][j] == newColor) {
			return;
		}

		if (screen[i][j] == oriColor) {
			screen[i][j] = newColor;

			fillPainting(screen, i - 1, j, oriColor, newColor);
			fillPainting(screen, i, j - 1, oriColor, newColor);
			fillPainting(screen, i + 1, j, oriColor, newColor);
			fillPainting(screen, i, j + 1, oriColor, newColor);
		}
	}
}
