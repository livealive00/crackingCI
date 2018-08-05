package com.psh.crackingCI.ch16;

import java.util.ArrayList;
import java.util.List;

public class P19 {
    public static void main(String[] args) {
        System.out.println(computePondSize(new int[][] {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        }));
    }

    public static List<Integer> computePondSize(int[][] land) {
        List<Integer> sizeList = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (!visited[r][c] && land[r][c] == 0) {
                    sizeList.add(compute(land, visited, r, c));
                }
            }
        }
        return sizeList;
    }

    public static int compute(int[][] land, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= land.length || c < 0 || c >= land[r].length ||
                land[r][c] != 0 || visited[r][c]) {
            return 0;
        }

        int size  = 1;
        visited[r][c] = true;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += compute(land, visited, r + dr, c + dc);
            }

        }
        return size;
    }
}
