package com.psh.crackingCI.ch01;

import java.util.Arrays;

/**
 * Created by Naver on 2018. 4. 3..
 */
public class P3 {

	public static void main(String[] args) {
		char[] arr = Arrays.copyOf("Mr John Smith".toCharArray() ,17);
		replaceSpace(arr, 13);
		System.out.println(Arrays.toString(arr));
	}

	public static void replaceSpace(char[] str, int size) {
		int resSize = size;
		for (int i = 0; i < size; i++) {
			if (str[i] == ' ') {
				resSize += 2;
			}
		}

		for (int i = size-1; i >= 0 ; i--) {
			char oriChar = str[i];
			if (oriChar == ' ') {
				str[--resSize] = '0';
				str[--resSize] = '2';
				str[--resSize] = '%';
			} else {
				str[--resSize] = oriChar;
			}
		}
	}
}
