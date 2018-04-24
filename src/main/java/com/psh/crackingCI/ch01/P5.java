package com.psh.crackingCI.ch01;

/**
 * Created by Naver on 2018. 4. 4..
 */
public class P5 {
	public static void main(String[] args) {
		System.out.println(isEditDistanceLessThanOne("pale", "ple"));
		System.out.println(isEditDistanceLessThanOne("pales", "pale"));
		System.out.println(isEditDistanceLessThanOne("pale", "bale"));
		System.out.println(isEditDistanceLessThanOne("pale", "bake"));
	}

	public static boolean isEditDistanceLessThanOne(String s1, String s2) {
		// check oneEdit : same chars, one diff
		// check insert / delete :
		System.out.println(Math.min(Double.NaN, 0.0));
		return isEqualByEditingOneChar(s1, s2) || isEqualByInsertOneChar(s1, s2);

	}

	public static boolean isEqualByInsertOneChar(String s1, String s2) {
		String shorter;
		String longer;
		if (s1.length() > s2.length()) {
			longer = s1;
			shorter = s2;
		} else if (s1.length() < s2.length()) {
			longer = s2;
			shorter = s1;
		} else {
			return false;
		}

		if (longer.length() - shorter.length() > 1) {
			return false;
		}

		return checkDiffOneChar(shorter, longer, false);

	}

	public static boolean isEqualByEditingOneChar(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		return checkDiffOneChar(s1, s2, true);
	}

	public static boolean checkDiffOneChar(String s1, String s2, boolean editable) {
		boolean diffOne = false;
		int longerBaseIdx = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i+longerBaseIdx)) {
				if (diffOne) {
					return false;
				} else {
					diffOne = true;
					if (!editable) {
						longerBaseIdx = 1;
					}
				}
			}
		}
		return true;
	}
}
