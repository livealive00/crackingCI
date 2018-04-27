package com.psh.crackingCI.ch04;

import com.psh.crackingCI.common.BinaryTreeNode;

import java.util.Stack;

/**
 * @author 박성현[sunghyun.park@navercorp.com]
 * @version 1.0
 */
public class P10 {

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


        BinaryTreeNode o_root = new BinaryTreeNode(10);
        BinaryTreeNode o_dep1_1 = new BinaryTreeNode(5);
        BinaryTreeNode o_dep1_2 = new BinaryTreeNode(15);
        o_root.setLeft(o_dep1_1);
        o_root.setRight(o_dep1_2);

        System.out.println(isSubtree(root, dep2_1));    // true
        System.out.println(isSubtree(root, o_root));    // false
    }

    // 당연히 값 기반으로 비교해야겠지
    public static boolean isSubtree(BinaryTreeNode t1, BinaryTreeNode t2) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(t1);
        while (!stack.isEmpty()) {
            BinaryTreeNode n = stack.pop();
            if (n.getVal() == t2.getVal()) {
                if (isSameTree(n, t2)) {
                    return true;
                }
            }

            if (n.getLeft() != null) {
                stack.push(n.getLeft());
            }
            if (n.getRight() != null) {
                stack.push(n.getRight());
            }
        }

        return false;
    }

    public static boolean isSameTree(BinaryTreeNode n1, BinaryTreeNode n2) {
        if (n1.getVal() != n2.getVal()) {
            return false;
        }

        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(n1);
        stack2.push(n2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            BinaryTreeNode c1 = stack1.pop();
            BinaryTreeNode c2 = stack2.pop();
            if (c1.getVal() != c2.getVal()) {
                return false;
            }

            if (c1.getLeft() != null && c2.getLeft() != null) {
                stack1.push(c1.getLeft());
                stack2.push(c2.getLeft());

            } else if(c1.getLeft() != null || c2.getLeft() != null) {
                return false;
            }

            if (c1.getRight() != null && c2.getRight() != null) {
                stack1.push(c1.getRight());
                stack2.push(c2.getRight());

            }  else if(c1.getRight() != null || c2.getRight() != null) {
                return false;
            }
        }

        return true;
    }
}
