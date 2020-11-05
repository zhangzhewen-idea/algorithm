package org.zhangzhewen.algorithm.union_find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 连接所有点的最小费用1584
 * <p>
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 *
 * @author zhangzhewen
 * @date 2020/11/5
 */
public class 连接所有点的最小费用1584 {
    public static void main(String[] args) {
        new 连接所有点的最小费用1584().minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});//result=20
    }

    static class UnionFind {
        int[] parent;
        public UnionFind(int len) {
            parent = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
        }
        int findRoot(int i) {
            if (i != parent[i]) {
                parent[i] = findRoot(parent[i]);
            }
            return parent[i];
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
    }

    public int minCostConnectPoints(int[][] points) {
        // 1.计算所有 点到点的坐标对 以及 cost，coordinates=[x,y,cost]
        List<int[]> coordinates = findAllCoordinates(points);
        // 2.对coordinates的cost进行升序排列
        Collections.sort(coordinates, Comparator.comparingInt(a -> a[2]));
        // 3.用 并查集 union 依次连通所有 子连通图，并计算总cost
        int minCost = 0;
        int part = points.length;
        UnionFind u = new UnionFind(part);
        for (int[] e : coordinates) {
            if (u.union(e[0], e[1])) {
                minCost += e[2];
            }
        }
        return minCost;
    }

    private List<int[]> findAllCoordinates(int[][] points) {
        List<int[]> res = new ArrayList<>();
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points.length; y++) {
                if (x != y) {
                    res.add(new int[]{x, y, Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1])});
                }
            }
        }
        return res;
    }

}
