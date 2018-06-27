package com.psh.crackingCI.ch10;


import org.apache.commons.lang3.tuple.Pair;

public class P09 {

    public static void main(String[] args) {
        int[][] mat = {
                {15,20,40,85},
                {20,35,80,95},
                {30,55,95,105},
                {40,80,100,200}
        };
        System.out.println(searchMatrix(mat, 55));
    }

    public static Pair<Integer, Integer> searchMatrix(int[][] mat, int x) {
        int row = mat.length-1;
        int col = 0;

        while (row >= 0 && col < mat[0].length) {
            if (mat[row][col] == x) {
                return Pair.of(row, col);
            } else if (mat[row][col] < x) {
                col++;
            } else {
                row--;
            }
        }

        return Pair.of(-1, -1);
    }
}
