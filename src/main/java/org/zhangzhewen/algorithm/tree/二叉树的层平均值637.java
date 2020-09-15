package org.zhangzhewen.algorithm.tree;

import java.util.*;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 二叉树的层平均值637 {

    public static void main(String[] args) {
        new 二叉树的层平均值637().averageOfLevels(new TreeNode(3,
                        new TreeNode(7, null, null),
                        new TreeNode(20,
                                new TreeNode(15, null, null),
                                new TreeNode(7, null, null)
                        )
                )
        );
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
}
