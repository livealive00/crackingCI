package com.psh.crackingCI.ch16;

import java.util.Arrays;

public class P06 {


    public static void main(String[] args) {
        int[] a = {1,3,15,11,2};
        int[] b = {23,127,235,19,8};
        System.out.println(minDiff(a, b));
    }

    public static int minDiff(int[] a, int [] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int aIdx = 0;
        int bIdx = 0;
        int minDiff = Math.abs(a[aIdx] - b[bIdx]);
        while (aIdx < a.length && bIdx < b.length) {
            minDiff = Math.min(minDiff, Math.abs(a[aIdx] - b[bIdx]));
            if (a[aIdx] < b[bIdx]) {
                aIdx++;
            } else {
                bIdx++;
            }
        }

        return minDiff;
    }
}
