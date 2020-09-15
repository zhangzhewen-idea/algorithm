package org.zhangzhewen.algorithm.tree;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 以 10^9 + 7 为模，返回这些数字之和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 从根到叶的二进制数之和1022 {

    public static void main(String[] args) {
        new 从根到叶的二进制数之和1022().sumRootToLeaf(new TreeNode(1,
                        new TreeNode(0,
                                null,
                                new TreeNode(1, new TreeNode(1, null, null), null)
                        )
                        ,
                        new TreeNode(1, null, null)
                )
        );
    }


    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return res;
    }

    public void preOrder(TreeNode root, int val) {
        if (root != null) {
            // 值先移位，后相加
            int tmp = (val << 1) + root.val;

            // 当前节点是叶子节点
            if (root.left == null && root.right == null) {
                res += tmp;
            } else {
                // 当前节点的左子节点不为空，继续递归，val的值是父节点的值，也就是tmp
                if (root.left != null) {
                    preOrder(root.left, tmp);
                }
                if (root.right != null) {
                    preOrder(root.right, tmp);
                }
            }
        }
    }
    /*
    自己写的
    public int sumRootToLeaf(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        int amount = 0 ;
        for(String s : res){
            amount += Integer.parseInt(s, 2);
        }
        return amount;
    }

    void dfs(TreeNode root,String s,List<String> res){
        if(root==null){
            return;
        }
        s += root.val;
        if(root.left==null&&root.right==null){
            res.add(s);
            return;
        }
        dfs(root.left,s,res);
        dfs(root.right,s,res);
    }*/


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
