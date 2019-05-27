package org.zhangzhewen.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/25
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return new ArrayList();
        }

        /*//BFS
        Queue<TreeNode> queue = new LinkedList();
        //Set<TreeNode> visited = new HashSet();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelResult.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
            result.add(levelResult);
        }*/
        //DFS
        dfs(result,root,1);
        return result;
    }
    private void dfs(List<List<Integer>> result,BinaryTreeNode currentNode,int level){
        if(currentNode==null){
            return;
        }
        if(result.size()<level){
            result.add(new ArrayList());
        }
        result.get(level-1).add(currentNode.val);
        dfs(result,currentNode.left,level+1);
        dfs(result,currentNode.right,level+1);
    }
}
