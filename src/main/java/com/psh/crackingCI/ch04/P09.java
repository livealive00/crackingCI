package com.psh.crackingCI.ch04;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.psh.crackingCI.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 박성현[sunghyun.park@navercorp.com]
 * @version 1.0
 */
public class P09 {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode dep1_1 = new BinaryTreeNode(5);
        BinaryTreeNode dep1_2 = new BinaryTreeNode(15);
        BinaryTreeNode dep2_1 = new BinaryTreeNode(2);
        BinaryTreeNode dep2_2 = new BinaryTreeNode(7);
        BinaryTreeNode dep2_3 = new BinaryTreeNode(12);
        BinaryTreeNode dep2_4 = new BinaryTreeNode(17);
        BinaryTreeNode dep3_1 = new BinaryTreeNode(1);

        root.setLeft(dep1_1);   // 10
        root.setRight(dep1_2);  // 5

        dep1_1.setLeft(dep2_1);
        //dep1_1.setRight(dep2_2);
        //dep1_2.setLeft(dep2_3);
        //dep1_2.setRight(dep2_4);

        //dep2_1.setLeft(dep3_1);

        printCombinations(root);
    }

    public static void printCombinations(BinaryTreeNode root) {
        Set<BinaryTreeNode> cands = Sets.newHashSet();
        addCand(cands, root);
        printCombHelper(Lists.newArrayList(root), cands);
    }

    public static void printCombHelper(List<BinaryTreeNode> list, Set<BinaryTreeNode> cands) {
        if (cands.isEmpty()) {
            printBinaryNodeList(list);
            return;
        }

        for (BinaryTreeNode cn : cands) {
            List<BinaryTreeNode> nList = new ArrayList<>(list);
            nList.add(cn);

            Set<BinaryTreeNode> nCands = new HashSet<>(cands);
            nCands.remove(cn);
            addCand(nCands, cn);

            printCombHelper(nList, nCands);
        }
    }

    public static void printBinaryNodeList(List<BinaryTreeNode> list) {
        System.out.print("[");
        for (BinaryTreeNode n : list) {
            System.out.print(n.getVal());
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void addCand(Set<BinaryTreeNode> cands, BinaryTreeNode n) {
        if (n == null) {
            return;
        }
        if (n.getLeft() != null) {
            cands.add(n.getLeft());
        }
        if (n.getRight() != null) {
            cands.add(n.getRight());
        }
    }

}
