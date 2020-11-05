package org.zhangzhewen.algorithm.union_find;

/**
 * 连通网络的操作次数1319
 * <p>
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 * <p>
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 *
 * @author zhangzhewen
 * @date 2020/11/5
 */
public class 连通网络的操作次数1319 {
    public static void main(String[] args) {
        new 连通网络的操作次数1319().makeConnected(12,
                new int[][]
                {{1, 5}, {1, 7}, {1, 2}, {1, 4}, {3, 7}, {4, 7}, {3, 5}, {0, 6}, {0, 1}, {0, 4}, {2, 6}, {0, 3}, {0, 2}});
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int len) {
            parent = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
        }

        boolean union(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA == rootB) {
                return false;
            }
            parent[rootA] = rootB;
            return true;
        }

        int findRoot(int i) {
            int root = i;
            while (root != parent[root]) {
                root = parent[root];
            }
            while (root != i) {
                int next = parent[i];
                parent[i] = root;
                i = next;
            }
            return root;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (n-1 > connections.length) {
            return -1;
        }
        UnionFind u = new UnionFind(n);
        int part = n;
        for (int i = 0; i < connections.length; i++) {
            if (u.union(connections[i][0], connections[i][1])) {
                n--;
            }
        }
        return n-1;
    }

}
