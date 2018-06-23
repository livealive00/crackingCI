package com.psh.crackingCI.ch10;

public class P05 {
    public static void main(String[] args) {
        System.out.println(search(new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
    }

    public static int search(String[] strings, String str) {
        return search(strings, str, 0, strings.length-1);
    }

    public static int search(String[] strings, String str, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (strings[mid].isEmpty()) {
            while(left <= mid && strings[mid].equals("")) {
                mid--;
            }

            if (mid < left) {
                mid = (left + right) / 2;
                while(mid <= right && strings[mid].equals("")) {
                    mid++;
                }
                if(mid > right) {
                    return -1;
                }
            }
        }

        int comp = str.compareTo(strings[mid]);
        if (comp == 0) {
            return mid;
        } else if (comp < 0) {
            return search(strings, str, left, mid-1);
        } else {
            return search(strings, str, mid+1, right);
        }
    }
}
