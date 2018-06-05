package com.psh.crackingCI.ch08;

/**
 * Created by Naver on 2018. 6. 5..
 */
public class P14 {

	public static void main(String[] args) {
		System.out.println(countEval("1^0|0|1", false));
		System.out.println(countEval("0&0&0&1^1|0", true));
	}

	public static int countEval(String expr, boolean answer) {
		if (expr.length() == 0) {
			return 0;
		}
		if (expr.length() == 1) {
			return expr.equals("1") == answer ? 1 : 0;
		}

		int cnt = 0;
		for (int i = 1; i < expr.length(); i+=2) {
			String leftExpr = expr.substring(0, i);
			String rightExpr = expr.substring(i+1, expr.length());

			char op = expr.charAt(i);
			if (op == '^') {
				if (answer) {
					cnt += countEval(leftExpr, true) * countEval(rightExpr, false);
					cnt += countEval(leftExpr, false) * countEval(rightExpr, true);
				} else {
					cnt += countEval(leftExpr, true) * countEval(rightExpr, true);
					cnt += countEval(leftExpr, false) * countEval(rightExpr, false);
				}

			} else if (op == '&') {
				if (answer) {
					cnt += countEval(leftExpr, true) * countEval(rightExpr, true);
				} else {
					cnt += countEval(leftExpr, false) * countEval(rightExpr, true);
					cnt += countEval(leftExpr, true) * countEval(rightExpr, false);
					cnt += countEval(leftExpr, false) * countEval(rightExpr, false);
				}

			} else if (op == '|') {
				if (answer) {
					cnt += countEval(leftExpr, true) * countEval(rightExpr, true);
					cnt += countEval(leftExpr, false) * countEval(rightExpr, true);
					cnt += countEval(leftExpr, true) * countEval(rightExpr, false);
				} else {
					cnt += countEval(leftExpr, false) * countEval(rightExpr, false);
				}

			} else {
				throw new UnsupportedOperationException();
			}

		}
		return cnt;
	}

}
