package org.zhangzhewen.algorithm.tree;

import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 二叉树的中序遍历94 {

    public static void main(String[] args) {
        new 二叉树的中序遍历94().inorderTraversal(
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, null)))
                )
        );
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
        return null;
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
