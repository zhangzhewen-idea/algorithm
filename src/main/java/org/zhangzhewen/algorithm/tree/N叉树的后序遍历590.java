package org.zhangzhewen.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * * 输入：
 * *
 * *        1
 * *    /   \    \
 * *   3     2   4
 * *  / \
 * * 5   6
 * <p>
 *  
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class N叉树的后序遍历590 {

    public static void main(String[] args) {
        new N叉树的后序遍历590().postorder(new Node(1,new ArrayList<Node>(){{
            add(new Node(3,new ArrayList<Node>(){{
                add(new Node(5,new ArrayList()));
                add(new Node(6,new ArrayList()));
            }}));
            add(new Node(2,new ArrayList()));
            add(new Node(4,new ArrayList()));
        }}));
    }
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node n = stack.pollLast();
            res.addFirst(n.val);
            for(Node child : n.children){
                if(child!=null){
                    stack.push(child);
                }
            }
        }

        return res;

    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
