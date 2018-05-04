package com.psh.crackingCI.ch05;

/**
 * Created by Naver on 2018. 5. 4..
 */
public class P06 {

	public static void main(String[] args) {
		System.out.println(filpCount(29, 15));
	}

	public static int filpCount(int a, int b) {
		int xor = a ^ b;
		int cnt = 0;
		for (int i=0; i < Integer.SIZE; i++) {
			if ((xor & (1 << i)) != 0) {
				cnt++;
			}
		}
		return cnt;
	}
}
