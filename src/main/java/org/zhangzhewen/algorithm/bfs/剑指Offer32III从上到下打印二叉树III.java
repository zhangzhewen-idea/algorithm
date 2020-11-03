package org.zhangzhewen.algorithm.bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指Offer32III从上到下打印二叉树III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 *
 * @author zhangzhewen
 * @date 2020/11/3
 */
public class 剑指Offer32III从上到下打印二叉树III {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList();
        LinkedList<TreeNode> aux = new LinkedList();
        queue.add(root);
        boolean positive = true;
        while (!queue.isEmpty()) {
            List<Integer> layer = new LinkedList<>();
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                root = queue.removeFirst();
                aux.add(root);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            while (!aux.isEmpty()) {
                if (positive) {
                    root = aux.removeFirst();
                } else {
                    root = aux.removeLast();
                }
                layer.add(root.val);
            }
            res.add(layer);
            positive = !positive;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
