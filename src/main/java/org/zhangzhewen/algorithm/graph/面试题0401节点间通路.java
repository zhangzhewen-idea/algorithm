package org.zhangzhewen.algorithm.graph;

import java.util.*;

public class 面试题0401节点间通路 {

    public static void main(String[] args) {
        boolean res = new 面试题0401节点间通路().findWhetherExistsPath(3,
                new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}},
                0,
                2);
        System.out.println(res);
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> sub = map.getOrDefault(graph[i][0], new ArrayList<>());
            sub.add(graph[i][1]);
            map.put(graph[i][0], sub);
        }
        return dfs(map, start, target, new HashSet());
    }

    boolean dfs(Map<Integer, List<Integer>> map, int start, int target, Set<Integer> visited) {
        if (start == target) {
            return true;
        }
        if (map.get(start) == null || visited.contains(start)) {
            return false;
        }
        visited.add(start);
        for (int v : map.get(start)) {
            if (dfs(map, v, target, visited)) {
                return true;
            }
        }
        return false;
    }

}
