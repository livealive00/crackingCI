package com.psh.crackingCI.ch05;

/**
 * Created by Naver on 2018. 5. 4..
 */
public class P07 {

	public static void main(String[] args) {
		int x = 13948;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(swapOddEven(x)));
	}

	public static int swapOddEven(int x) {
		int evenMask = 0x55555555;
		int oddMask = 0xaaaaaaaa;
		return (x & evenMask) << 1 | (x & oddMask) >>> 1;
	}
}
