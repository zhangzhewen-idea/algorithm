package org.zhangzhewen.algorithm.graph;

public class Floyd {
    public static void main(String[] args) {
        System.out.println("有向图");
        Floyd.floyd(new int[][]{
                {Integer.MAX_VALUE,6,1,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,4,Integer.MAX_VALUE,1},
                {Integer.MAX_VALUE,1,Integer.MAX_VALUE,Integer.MAX_VALUE},
        });
        System.out.println();
        System.out.println("无向图");
        Floyd.floyd(new int[][]{
                {Integer.MAX_VALUE,6,1,Integer.MAX_VALUE},
                {6,Integer.MAX_VALUE,4,1},
                {1,4,Integer.MAX_VALUE,1},
                {Integer.MAX_VALUE,1,1,Integer.MAX_VALUE},
        });
    }

    public static void floyd(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        int[][] path = new int[n][n];

        // 初始化距离矩阵和路径矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (dist[i][j] != Integer.MAX_VALUE && i != j) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }

        // 计算最短路径
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        // 显示路径
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && path[i][j] != -1) {
                    System.out.print("Path from " + i + " to " + j + ", min["+dist[i][j]+"] : ");
                    int p = j;
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    while (p != i) {
                        p = path[i][p];
                        sb.insert(0, p + " -> ");
                    }
//                    sb.insert(0, i + " -> ");
                    System.out.println(sb.toString());
                }
            }
        }
    }

}
