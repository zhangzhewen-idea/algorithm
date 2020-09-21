package org.zhangzhewen.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 最长同值路径687 {

    public static void main(String[] args) {
        /*new 两数之和IV_输入BST653().findTarget(new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2,
                                        null,
                                        null
                                )
                                ,
                                new TreeNode(4,
                                        null,
                                        null
                                )
                        )
                        ,
                        new TreeNode(6,
                                null,
                                new TreeNode(7,
                                        null,
                                        null
                                )
                        )
                ), 9
        );*/
        /*new 两数之和IV_输入BST653().findTarget(new TreeNode(2,
                        new TreeNode(1,
                                null, null
                        )
                        ,
                        new TreeNode(3,
                                null, null
                        )
                ), 4
        );*/
        int res = new 最长同值路径687().longestUnivaluePath(
                new TreeNode(1,
                        new TreeNode(1,
                                new TreeNode(1,
                                        new TreeNode(1,
                                                null,
                                                null
                                        ),
                                        null
                                ),
                                new TreeNode(1,
                                        null,
                                        null
                                )
                        )
                        ,
                        new TreeNode(1,
                                null,
                                null
                        )
                )
        );
        System.out.println(res);
    }

    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        int a = depth(root,root.val)-1;
        int b = longestUnivaluePath(root.left);
        int c = longestUnivaluePath(root.right);
        return Math.max(a, Math.max( b,c));
    }

    int depth(TreeNode root,int val){
        if(root==null){
            return 0;
        }
        if(root.val!=val){
            return 0;
        }
        int l  =depth(root.left,val);
        int r  =depth(root.right,val);
        return l+r+1;
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

    void dfs(Map<TreeNode,Integer> leafMap, TreeNode root, int d){
        if(root==null){
            return;
        }
        else if(root.left==null&&root.right==null){
            leafMap.put(root,d);
        }
        dfs(leafMap,root.left,d+1);
        dfs(leafMap,root.right,d+1);
    }


}
