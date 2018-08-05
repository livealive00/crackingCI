package com.psh.crackingCI.ch16;

public class P17 {

    public static void main(String[] args) {
        int[] arr = {2,3,-8,-1,2,4-2,3};
        System.out.println(maxSum(arr));
        System.out.println(maxSum(new int[]{-3,-1,-2}));
    }

    public static int maxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int x : arr) {
            sum += x;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}
