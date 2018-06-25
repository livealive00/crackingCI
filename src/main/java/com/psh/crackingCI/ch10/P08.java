package com.psh.crackingCI.ch10;

import java.util.BitSet;

public class P08 {
    public static void main(String[] args) {
        int[] arr = {10, 111, 132, 5, 323, 111, 77, 5};
        printDuplicateElem(arr);
    }

    public static void printDuplicateElem(int[] arr) {
        BitSet bs = new BitSet(32000);
        for (int e : arr) {
            if (bs.get(e)) {
                System.out.println(e);
            } else {
                bs.set(e);
            }
        }
    }
}
