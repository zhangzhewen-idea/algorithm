package org.zhangzhewen.algorithm.tree;

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

    public static void main(String[] args) {
        dfs(TreeNode.buildTrees());
    }
}
