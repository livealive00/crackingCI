package com.psh.crackingCI.ch04;

import com.psh.crackingCI.common.BinaryTreeNode;

public class P12 {
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        
        BinaryTreeNode n_1_1 = new BinaryTreeNode(5);
        BinaryTreeNode n_1_2 = new BinaryTreeNode(11);
        
        BinaryTreeNode n_2_1 = new BinaryTreeNode(-5);
        BinaryTreeNode n_2_2 = new BinaryTreeNode(100);
        BinaryTreeNode n_2_3 = new BinaryTreeNode(0);
        BinaryTreeNode n_2_4 = new BinaryTreeNode(300);
        
        BinaryTreeNode n_3_1 = new BinaryTreeNode(-11);
        
        root.setLeft(n_1_1);
        root.setRight(n_1_2);
        
        n_1_1.setLeft(n_2_1);
        n_1_1.setRight(n_2_2);
        n_1_2.setLeft(n_2_3);
        n_1_2.setRight(n_2_4);
        n_2_3.setLeft(n_3_1);
        
        System.out.println(getNumPathsForSum(root, 10));
    }
    
    public static int getNumPathsForSum(BinaryTreeNode root, int targetSum) {
        return getNumPathsForSum(root, targetSum, 0);
    }
    
    public static int getNumPathsForSum(BinaryTreeNode n, int targetSum, int startSum) {
        if (n == null) {
            return 0;
        }
        
        int res = 0;
        if (startSum + n.getVal() == targetSum) {
            res++;
        }
        
        res += getNumPathsForSum(n.getLeft(), targetSum, startSum + n.getVal());
        res += getNumPathsForSum(n.getParent(), targetSum, startSum + n.getVal());
        
        return res;
    }
    
}