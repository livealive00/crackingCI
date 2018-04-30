package com.psh.crackingCI.ch05;

/**
 * @author 박성현[sunghyun.park@navercorp.com]
 * @version 1.0
 */
public class P01 {

    public static void main(String[] args) {
        int n = Integer.parseInt("110011", 2);
        int m = Integer.parseInt("001", 2);
        int j = 2;
        int i = 4;

        System.out.println(Integer.toBinaryString(updatebit(n,m,j,i))); // 100111
    }

    public static int updatebit(int n, int m, int j, int i) {
        // mask
        int leftMask = (~0) << (i+1);
        //System.out.println(Integer.toBinaryString(leftMask));
        int rightMask = ~((~0) << (j));
        //System.out.println(Integer.toBinaryString(rightMask));
        return (n & (leftMask | rightMask)) | (m << j);
    }

}
