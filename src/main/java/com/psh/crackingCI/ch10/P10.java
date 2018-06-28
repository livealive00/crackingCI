package com.psh.crackingCI.ch10;

import lombok.ToString;

public class P10 {


    public static void main(String[] args) {
        int[] stream = {5,1,4,4,5,9,7,13,3};

        Node root = null;
        for (int a : stream) {
            if (root == null) {
                root = new Node(a);
            } else {
                insert(root, a);
            }
        }
        System.out.println(root);
        System.out.println(getRankOfNumber(root, 1)); // 0
        System.out.println(getRankOfNumber(root, 3)); // 1
        System.out.println(getRankOfNumber(root, 4)); // 3
        System.out.println(getRankOfNumber(root, 11)); // -1

    }

    public static void insert(Node node, int x) {
        Node cur = node;
        while (cur != null) {
            if (x < cur.val) {
                cur.numLeftChildren++;
                if (cur.left == null) {
                    cur.left = new Node(x, 1);
                    return;
                } else {
                    cur = cur.left;
                }


            } else if (x > cur.val) {
                if (cur.right == null) {
                    cur.right = new Node(x, 1);
                    return;
                } else {
                    cur = cur.right;
                }

            } else { // equal
                cur.cnt += 1;
                return;
            }
        }

    }

    public static int getRankOfNumber(Node node, int x) {
        int num = 0;
        while (node != null) {
            if (x < node.val) {
                node = node.left;

            } else if (x > node.val){
                num += node.numLeftChildren + node.cnt;
                node = node.right;

            } else {    // equal
                return num + node.cnt + node.numLeftChildren -1;
            }
        }
        return -1;
    }

    @ToString
    static class Node {
        int val;
        Node left;
        Node right;
        int numLeftChildren = 0;
        int cnt = 0;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
