package com.psh.crackingCI.ch10;

import java.util.Arrays;

public class P11 {

    public static void main(String[] args) {
        int[] a = {5,3,1,2,3};
        System.out.println(Arrays.toString(peakValley(a)));
    }

    public static int[] peakValley(int[] a) {
        int[] res = Arrays.copyOf(a, a.length);
        if (res.length <=2) {
            return res;
        }

        for (int i = 1; i < res.length; i += 2) {
            int left = res[i-1];
            int mid = res[i];
            int right = i+1 < res.length ? res[i+1] : Integer.MIN_VALUE;
            if (mid < left || mid < right) {
                if (left > right) {
                    swap(res, i-1, i);
                } else {
                    swap(res, i+1, i);
                }
            }
        }

        return res;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
