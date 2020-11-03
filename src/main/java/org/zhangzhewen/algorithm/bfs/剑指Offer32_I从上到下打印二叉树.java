package org.zhangzhewen.algorithm.bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指Offer32_I从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 * <p>
 * [3,9,20,15,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 *
 * @author zhangzhewen
 * @date 2020/11/3
 */
public class 剑指Offer32_I从上到下打印二叉树 {

    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.removeFirst();
            res.add(root.val);
            if(root.left!=null){
                queue.add(root.left);
            }
            if(root.right!=null){
                queue.add(root.right);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
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
