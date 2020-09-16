package org.zhangzhewen.algorithm.tree;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 *
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 面试题17_12_BiNode {

    public static void main(String[] args) {
        new 面试题17_12_BiNode().convertBiNode(new TreeNode(5,
                        new TreeNode(2,
                                null,
                                null
                        )
                        ,
                        new TreeNode(13, null, null)
                )
        );
    }


    TreeNode ans = new TreeNode(0);
    TreeNode pre = ans;
    public TreeNode convertBiNode(TreeNode root) {
        dfs(root);
        return ans.right;
    }
    void dfs(TreeNode root){
        if(root!=null){
            dfs(root.left);
            pre.right = root;
            pre = root;
            pre.left = null;//一定要这个位置，在之前的位置，最后一个结点的left不会变null
            dfs(root.right);
        }
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
