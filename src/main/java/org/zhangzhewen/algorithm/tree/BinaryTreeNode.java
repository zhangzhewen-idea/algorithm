package org.zhangzhewen.algorithm.tree;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/21
 */
public class BinaryTreeNode {

    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int x) {
        val = x;
    }

    public static BinaryTreeNode buildTrees(){
        BinaryTreeNode a1 = new BinaryTreeNode(5);
        BinaryTreeNode a2 = new BinaryTreeNode(3);
        BinaryTreeNode a3 = new BinaryTreeNode(7);
        BinaryTreeNode a4 = new BinaryTreeNode(2);
        BinaryTreeNode a5 = new BinaryTreeNode(4);
        BinaryTreeNode a6 = new BinaryTreeNode(1);
        BinaryTreeNode a7 = new BinaryTreeNode(6);
        BinaryTreeNode a8 = new BinaryTreeNode(8);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a4.left = a6;

        a3.left = a7;
        a3.right = a8;

        return a1;
    }
}
