package com.psh.crackingCI.ch04;

import com.psh.crackingCI.common.BinaryTreeNode;

/**
 * @author 박성현[sunghyun.park@navercorp.com]
 * @version 1.0
 */
public class P08 {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode dep1_1 = new BinaryTreeNode(5);
        BinaryTreeNode dep1_2 = new BinaryTreeNode(15);
        BinaryTreeNode dep2_1 = new BinaryTreeNode(2);
        BinaryTreeNode dep2_2 = new BinaryTreeNode(7);
        BinaryTreeNode dep2_3 = new BinaryTreeNode(12);
        BinaryTreeNode dep2_4 = new BinaryTreeNode(17);
        BinaryTreeNode dep3_1 = new BinaryTreeNode(1);
        BinaryTreeNode dep4_1 = new BinaryTreeNode(0);

        root.setLeft(dep1_1);
        root.setRight(dep1_2);

        dep1_1.setLeft(dep2_1);
        dep1_1.setRight(dep2_2);
        dep1_2.setLeft(dep2_3);
        dep1_2.setRight(dep2_4);

        dep2_1.setLeft(dep3_1);

        dep3_1.setLeft(dep4_1);

        System.out.println(firstCommonParent(root, dep4_1, dep2_2).getVal());   // 5
        System.out.println(firstCommonParent(root, dep4_1, dep2_4).getVal());   // 10
    }

    // c.f) 부모노드를 알고 있다면, 양쪽 depth를 구하고 더 깊은 노드를 위로 올린뒤 하나씩 올리면서 같은지 비교.
    // 노드는 항상 트리내부에 포함되어 있다고 가정.
    public static BinaryTreeNode firstCommonParent(BinaryTreeNode parent, BinaryTreeNode n1, BinaryTreeNode n2) {
        if (n1 == parent || n2 == parent) {
            return parent;
        }
        boolean isLeftN1 = isDescendant(parent.getLeft(), n1);
        boolean isLeftN2 = isDescendant(parent.getLeft(), n2);

        if (isLeftN1 != isLeftN2) {
            return parent;
        }

        BinaryTreeNode nextParent = isLeftN1 ? parent.getLeft() : parent.getRight();

        return firstCommonParent(nextParent, n1, n2);

    }

    public static boolean isDescendant(BinaryTreeNode parent, BinaryTreeNode n) {
        if (parent == null) {
            return false;
        }
        if (parent == n) {
            return true;
        }
        return isDescendant(parent.getLeft(), n) || isDescendant(parent.getRight(), n);
    }
}
