package com.psh.crackingCI.ch05;

/**
 * Created by Naver on 2018. 5. 1..
 */
public class P03 {
	public static void main(String[] args) {
		System.out.println(getLongest(1775)); // 8
		System.out.println(getLongest(20)); // 3
		System.out.println(getLongest(-1)); // 3
	}

	public static int getLongest(int x) {

		int max = 0;
		int beforeLen = 0;
		int curLen = 0;
		boolean convertToOne = false;
		for (int i = 0; i < Integer.SIZE; i++) {
			boolean v = (x & (1 << i)) != 0 ;

			if (v) {	// 1
				curLen++;
				max = Math.max(max, curLen);

			} else {	// 0
				if (!convertToOne) {
					convertToOne = true;

				} else {
					max = Math.max(max, curLen+beforeLen+1);
					convertToOne = false;

				}

				beforeLen = curLen;
				curLen = 0;
			}
		}
		return max;
	}

}
