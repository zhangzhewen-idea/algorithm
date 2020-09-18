package org.zhangzhewen.algorithm.tree;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 *  
 * <p>
 * 案例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 两数之和IV_输入BST653 {

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
        new 两数之和IV_输入BST653().findTarget(new TreeNode(0,
                        new TreeNode(-1,
                                new TreeNode(-3,
                                        null,
                                        null
                                )
                                ,
                                null
                        )
                        ,
                        new TreeNode(2,
                                null,
                                new TreeNode(4,
                                        null,
                                        null
                                )
                        )
                ), -4
        );
    }

    public boolean findTarget(TreeNode root, int k) {
        return helper2(root,root,k);
    }

    boolean helper2(TreeNode root,TreeNode target, int k){
        if(root == null){
            return false;
        }
        return (
                helper2(root.left,target,k) || helper2(root.right,target,k)
                        || (root.val<k && helper(target,root,k-root.val))
        );
    }

    boolean helper(TreeNode root,TreeNode self, int k){
        if(root == null){
            return false;
        }
        else if(root.val==k && root != self){
            return true;
        }
        else if(root.val<k){
            return helper(root.right,self,k);
        }
        else if(root.val>k){
            return helper(root.left,self,k);
        }else{
            return false;
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
