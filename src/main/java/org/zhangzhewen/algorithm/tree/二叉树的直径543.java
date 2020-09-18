package org.zhangzhewen.algorithm.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 二叉树的直径543 {

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
        new 二叉树的直径543().diameterOfBinaryTree(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        null,
                                        null
                                )
                                ,
                                new TreeNode(5,
                                        null,
                                        null
                                )
                        )
                        ,
                        new TreeNode(3,
                                null,
                                null
                        )
                )
        );
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        depth(root);
        return max;
    }

    int max = Integer.MIN_VALUE;
    int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if(lDepth+rDepth>max){
            max = lDepth+rDepth;
        }
        return Math.max(lDepth,rDepth)+1;
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
