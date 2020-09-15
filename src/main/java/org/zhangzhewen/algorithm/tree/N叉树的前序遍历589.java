package org.zhangzhewen.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 * *
 * *        1
 * *    /   \    \
 * *   3     2   4
 * *  / \
 * * 5   6
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class N叉树的前序遍历589 {

    public static void main(String[] args) {
        new N叉树的前序遍历589().preorder(new Node(1,new ArrayList<Node>(){{
            add(new Node(3,new ArrayList<Node>(){{
                add(new Node(5,new ArrayList()));
                add(new Node(6,new ArrayList()));
            }}));
            add(new Node(2,new ArrayList()));
            add(new Node(4,new ArrayList()));
        }}));
    }

    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }



    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
