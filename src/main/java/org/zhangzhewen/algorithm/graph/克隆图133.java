package org.zhangzhewen.algorithm.graph;

import java.util.*;

public class 克隆图133 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors = new ArrayList() {{
            add(n2);
            add(n4);
        }};

        n2.neighbors = new ArrayList() {{
            add(n1);
            add(n3);
        }};

        n3.neighbors = new ArrayList() {{
            add(n2);
            add(n4);
        }};

        n4.neighbors = new ArrayList() {{
            add(n1);
            add(n3);
        }};

        new 克隆图133().cloneGraph(n1);
    }


    /* 利用dfs */
    Map<Integer, Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node currentNode = new Node(node.val, new ArrayList<>());
        visited.put(node.val, currentNode);
        for (Node child : node.neighbors) {
            currentNode.neighbors.add(cloneGraph(child));
        }
        return currentNode;
    }

    /* 利用bfs
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        Map<Integer, Node> visited = new HashMap();
        Node answer = new Node(node.val, new ArrayList());
        visited.put(node.val, answer);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.removeFirst();
            for (Node neighbor : currentNode.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    queue.addLast(neighbor);
                    visited.put(neighbor.val, new Node(neighbor.val, new ArrayList()));
                }
                visited.get(currentNode.val).neighbors.add(visited.get(neighbor.val));
            }
        }
        return answer;
    }
    */

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
