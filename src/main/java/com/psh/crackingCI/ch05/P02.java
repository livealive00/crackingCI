package com.psh.crackingCI.ch05;

/**
 * Created by Naver on 2018. 5. 1..
 */
public class P02 {

	public static void main(String[] args) {

		System.out.println(toBinaryNumber(0.625));
	}

	public static String toBinaryNumber(double x) {
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		double cur = 1;
		while (x > 0) {
			if (sb.length() >= 32) {
				return "ERROR";
			}

			cur = cur / 2;
			if (x >= cur) {
				x -= cur;
				sb.append("1");
			} else {
				sb.append("0");
			}
		}

		return sb.toString();
	}
}
