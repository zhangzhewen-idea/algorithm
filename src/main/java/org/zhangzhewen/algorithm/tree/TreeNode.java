package org.zhangzhewen.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/20
 */
public class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode(int val, List<TreeNode> children){
        this.val = val;
        this.children = children;
    }

    public static TreeNode buildTrees(){
        TreeNode a1 = new TreeNode(1,null);
        TreeNode a2 = new TreeNode(2,null);
        TreeNode a3 = new TreeNode(3,null);
        TreeNode a4 = new TreeNode(4,null);
        TreeNode a5 = new TreeNode(5,null);
        TreeNode a6 = new TreeNode(6,null);
        TreeNode a7 = new TreeNode(7,null);
        TreeNode a8 = new TreeNode(8,null);

        a1.children =new ArrayList<TreeNode>(){{
            add(a2);
            add(a3);
            add(a4);
        }};

        a2.children =new ArrayList<TreeNode>(){{
            add(a5);
        }};

        a3.children =new ArrayList<TreeNode>(){{
            add(a8);
        }};

        a5.children =new ArrayList<TreeNode>(){{
            add(a6);
            add(a7);
        }};

        return a1;
    }
}


