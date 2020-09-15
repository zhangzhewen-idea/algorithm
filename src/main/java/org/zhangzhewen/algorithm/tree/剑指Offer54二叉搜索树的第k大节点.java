package org.zhangzhewen.algorithm.tree;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 *  
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 剑指Offer54二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        new 剑指Offer54二叉搜索树的第k大节点().kthLargest(new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, new TreeNode(1, null, null), null),
                                new TreeNode(4, null, null)
                        ),
                        new TreeNode(6, null, null)
                )
                , 3
        );
    }

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
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
