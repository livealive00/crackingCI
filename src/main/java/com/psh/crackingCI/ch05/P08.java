package com.psh.crackingCI.ch05;

import java.util.Arrays;

/**
 * @author 박성현[sunghyun.park@navercorp.com]
 * @version 1.0
 */
public class P08 {

    public static void main(String[] args) {
        byte[] screen = new byte[20];  // 160
        drawHorizontalLine(screen, 40, 1, 38, 2); //80 * 10
        System.out.println(Arrays.toString(screen));
    }

    public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        if (x2 < x1) {
            return;
        }

        int baseIdx = (width/8) * y;

        // start
        int firstArrIdx = baseIdx + x1 / 8;
        int firstStartIdx = x1 % 8;

        int lastArrIdx = baseIdx + x2 / 8;
        int lastEndIdx = x2 % 8;

        if (firstArrIdx == lastArrIdx) { // same block
            int i = firstStartIdx;
            while (i <= lastEndIdx) {
                screen[firstArrIdx] |= (1 << (7-i));
                i++;
            }

        } else {
            int i = firstStartIdx;
            while (i <= 7) {
                screen[firstArrIdx] |= (1 << (7-i));
                i++;
            }

            i = 0;
            while (i <= lastEndIdx) {
                screen[lastArrIdx] |= (1 << (7-i));
                i++;
            }
        }

        // mid
        for (int i = (x1/8)+1; i < (x2/8); i++) {
            int screenIdx = baseIdx + i;
            screen[screenIdx] = -1;
        }

    }
}
