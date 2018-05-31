package com.psh.crackingCI.ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naver on 2018. 5. 31..
 */
public class P09 {

	public static void main(String[] args) {
		System.out.println(getParens(3));
	}

	public static List<String> getParens(int n) {
		List<String> res = new ArrayList<>();
		getParens(0, 0, n, "", res);
		return res;
	}

	public static void getParens(int left, int right, int n, String prefix, List<String> result) {
		if (left == n && right == n) {
			result.add(prefix);
			return;
		}

		if (left <= right) {
			getParens(left+1 , right, n, prefix + "(", result);
			return;
		}

		if (left == n){
			getParens(left, right+1, n, prefix + ")", result);
			return;
		}

		if (left < n) {
			getParens(left+1, right, n, prefix + "(", result);
		}

		if (right < n) {
			getParens(left, right+1, n, prefix + ")", result);
		}
	}
}
