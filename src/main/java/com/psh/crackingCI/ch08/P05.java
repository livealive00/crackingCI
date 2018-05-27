package com.psh.crackingCI.ch08;

/**
 * Created by Naver on 2018. 5. 27..
 */
public class P05 {
	public static void main(String[] args) {
		System.out.println(product(7,9));
	}

	public static int product(int a, int b) {
		int smaller;
		int bigger;
		if (a < b) {
			smaller = a;
			bigger = b;
		} else {
			smaller = b;
			bigger = a;
		}
		return productHelper(smaller, bigger);
	}

	public static int productHelper(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}

		int smallerDiv2 = smaller >> 1;
		int half1 = productHelper(smallerDiv2, bigger);
		int half2 = half1;
		if (smallerDiv2 % 2 == 1) {
			half2 += bigger;
		}
		return half1 + half2;
	}
}
