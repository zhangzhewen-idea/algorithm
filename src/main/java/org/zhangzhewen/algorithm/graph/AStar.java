package org.zhangzhewen.algorithm.graph;

import java.util.*;

public class AStar {

    static class Node implements Comparable<Node> {
        int x, y;
        int g, h;  // g: 从起点走到该点的代价，h: 从该点到终点的估计代价

        public Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
        }

        public int f() {
            return g + h;  // f = g + h
        }

        public int compareTo(Node other) {
            return Integer.compare(this.f(), other.f());
        }
    }

    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  // 右、左、下、上

    static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static boolean isInside(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    static List<Node> neighbors(int[][] grid, int x, int y) {
        List<Node> result = new ArrayList<>();
        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (isInside(grid, nx, ny) && grid[nx][ny] == 0) {
                result.add(new Node(nx, ny, 0, 0));
            }
        }
        return result;
    }

    static int aStar(int[][] grid, int sx, int sy, int tx, int ty) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(sx, sy, 0, manhattan(sx, sy, tx, ty)));
        Set<String> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x, y = node.y;
            if (x == tx && y == ty) {
                return node.g;
            }
            if (!visited.contains(x + "," + y)) {
                visited.add(x + "," + y);
                for (Node neighbor : neighbors(grid, x, y)) {
                    int ng = node.g + 1;  // 假设所有格子的代价都是1
                    int nh = manhattan(neighbor.x, neighbor.y, tx, ty);
                    pq.offer(new Node(neighbor.x, neighbor.y, ng, nh));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int sx = 0, sy = 0, tx = 3, ty = 3;
        int shortestPath = aStar(grid, sx, sy, tx, ty);
        System.out.println(shortestPath);

    }
}