package org.zhangzhewen.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指Offer34二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 *  
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 *
 * @author zhangzhewen
 * @date 2020/11/3
 */
public class 剑指Offer34二叉树中和为某一值的路径 {

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4_2 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5_2 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);

        n5.left = n4;
        n4.left = n11;
        n11.left = n7;
        n11.right = n2;

        n5.right = n8;
        n8.left = n13;
        n8.right = n4_2;
        n4_2.left = n5_2;
        n4_2.right = n1;

        new 剑指Offer34二叉树中和为某一值的路径().pathSum(n5, 22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
