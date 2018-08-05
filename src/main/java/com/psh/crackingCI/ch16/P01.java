package com.psh.crackingCI.ch16;

public class P01 {
    public static void main(String[] args) {
        swap1(1,2);
        swap2(1,2);
    }

    public static void swap1(int a, int b) {
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }

    public static void swap2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }
}
