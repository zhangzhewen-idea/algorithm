package org.zhangzhewen.algorithm.tree;

import java.util.Stack;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/21
 */
public class DFS {
    private static void dfs(TreeNode t){
        if(t==null){
            return;
        }
        System.out.println(t.val);
        if(t.children!=null) {
            for (TreeNode t2 : t.children) {
                dfs(t2);
            }
        }
    }

    private static void dfs2(TreeNode r){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(r);
        while(stack.size()>0){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if(cur.children!=null){
                for (int i = cur.children.size()-1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }

    }


    private static void dfs3(TreeNode r){


    }



















    public static void main(String[] args) {
        dfs3(TreeNode.buildTrees());


    }
}
