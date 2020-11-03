package org.zhangzhewen.algorithm.tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 剑指Offer07重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 *
 * @author zhangzhewen
 * @date 2020/11/2
 */
public class 剑指Offer07重建二叉树 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> valueAndIndexMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            valueAndIndexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueAndIndexMap);
    }

    TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> valueAndIndexMap) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        } else {
            int inorderIndex = valueAndIndexMap.get(preorder[preStart]);
            int leftSize = inorderIndex - inStart;
            int rightSize = inEnd - inorderIndex;
            root.left = helper(preorder, preStart + 1, preEnd - rightSize, inorder, inStart, inorderIndex - 1, valueAndIndexMap);
            root.right = helper(preorder, preStart + leftSize + 1, preEnd, inorder, inorderIndex + 1, inEnd, valueAndIndexMap);
        }
        return root;
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
