package org.zhangzhewen.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 我们应返回其最大深度，3。
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class N叉树的最大深度559 {

    public static void main(String[] args) {
        new N叉树的最大深度559().maxDepth(new Node(1, new ArrayList<Node>() {{
            add(new Node(3, new ArrayList<Node>() {{
                add(new Node(5, new ArrayList()));
                add(new Node(6, new ArrayList()));
            }}));
            add(new Node(2, new ArrayList()));
            add(new Node(4, new ArrayList()));
        }}));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            depth += 1;
            Node node = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.pollFirst();
                for (Node child : node.children) {
                    if (child != null) {
                        q.add(child);
                    }
                }
            }
        }

        return depth;
    }

    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }
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
