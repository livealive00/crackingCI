package com.psh.crackingCI.ch01;

/**
 * Created by Naver on 2018. 4. 5..
 */
public class P6 {

	public static void main(String[] args) {
		System.out.println(compress("aabccccaaa"));
	}

	public static String compress(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		char lastCh = str.charAt(0);
		int lastChCnt = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char curCh = str.charAt(i);
			if (lastCh == curCh) {	// same as top char
				lastChCnt++;

			} else {
				sb.append(lastCh);
				sb.append(lastChCnt);

				lastCh = curCh;
				lastChCnt = 1;
			}
		}

		sb.append(lastCh);
		sb.append(lastChCnt);

		if (sb.length() > str.length()) {
			return str;
		} else {
			return sb.toString();
		}
	}

}
