package org.zhangzhewen.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

 */
public class 二叉树的锯齿形层序遍历103 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode a3 = new TreeNode(3);
        TreeNode a9 = new TreeNode(9);
        TreeNode a20 = new TreeNode(20);
        TreeNode a15 = new TreeNode(15);
        TreeNode a7 = new TreeNode(7);
        a3.left = a9;
        a3.right = a20;
        a20.left = a15;
        a20.right = a7;

        new 二叉树的锯齿形层序遍历103().zigzagLevelOrder(a3);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean positive = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> line = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if(positive){
                    line.addLast(node.val);
                }else{
                    line.addFirst(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            positive = !positive;
            res.add(line);
        }
        return res;
    }
}
