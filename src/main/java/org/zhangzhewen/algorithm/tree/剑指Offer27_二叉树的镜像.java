package org.zhangzhewen.algorithm.tree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 剑指Offer27_二叉树的镜像 {

    public static void main(String[] args) {

    }

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode aux = root.left;

        root.left = mirrorTree(root.right);
        root.right = mirrorTree(aux);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
