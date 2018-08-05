package com.psh.crackingCI.ch16;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.MathUtils;

import static java.lang.Math.log;
import static org.apache.commons.math3.util.CombinatoricsUtils.factorial;

public class P05 {
    public static void main(String[] args) {
        System.out.println(factorial(2) + ", " + factorialZeros(2));
        System.out.println(factorial(5) + ", " + factorialZeros(5));
        System.out.println(factorial(11) + ", " + factorialZeros(11));
        System.out.println(factorial(15) + ", " + factorialZeros(15));
    }

    public static int factorialZeros(int n) {
        int cnt2 = 0;
        int cnt5 = 0;
        for (int i = 2; i <=n; i++) {
            if (i % 5 == 0) {
                cnt5 += (int)(log(i) / log(5));
            }
            if (i % 2 == 0) {
                cnt2 += (int)(log(i) / log(2));
            }
        }
        return Math.min(cnt2, cnt5);
    }
}
