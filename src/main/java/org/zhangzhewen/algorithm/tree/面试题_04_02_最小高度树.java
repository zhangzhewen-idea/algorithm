package org.zhangzhewen.algorithm.tree;

/**
 * 面试题_04_02_最小高度树
 * <p>
 * <p>
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author zhangzhewen
 * @date 2020/9/11
 */
public class 面试题_04_02_最小高度树 {

    public static void main(String[] args) {
        TreeNode r = new 面试题_04_02_最小高度树().sortedArrayToBST(new int[]{1, 3, 5, 6, 8, 11, 12});
        inorder(r);
    }

    static void inorder(TreeNode r) {
        if (r == null) {
            return;
        }
        inorder(r.left);
        System.out.println(r.val);
        inorder(r.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int l, int h) {
        if (l > h) {
            return null;
        }
        int mid = l + (h - l) / 2;
        TreeNode e = new TreeNode(nums[mid]);
        e.left = helper(nums, l, mid - 1);
        e.right = helper(nums, mid + 1, h);
        return e;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


