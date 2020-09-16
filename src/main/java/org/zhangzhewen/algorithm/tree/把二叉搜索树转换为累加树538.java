package org.zhangzhewen.algorithm.tree;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *  
 *
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 把二叉搜索树转换为累加树538 {

    public static void main(String[] args) {
        new 把二叉搜索树转换为累加树538().convertBST(new TreeNode(5,
                        new TreeNode(2,
                                null,
                                null
                        )
                        ,
                        new TreeNode(13, null, null)
                )
        );
    }


    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
