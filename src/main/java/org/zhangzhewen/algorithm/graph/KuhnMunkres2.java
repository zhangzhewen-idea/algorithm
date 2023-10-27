package org.zhangzhewen.algorithm.graph;

import java.util.Arrays;

public class KuhnMunkres2 {
    private int[][] graph;
    private int[] labels;
    private boolean[] visited;
    private int[] match;

    public static void main(String[] args) {
        /*
            示例请参照：https://blog.csdn.net/qq_37457202/article/details/80161274
        */
        int[][] arr = new int[][]{
                {3,-1,4},
                {2,1,3},
                {0,0,5}
        };
//        new Km().calc(arr);
        System.out.println(new KuhnMunkres.KuhnMunkresAlgorithm().getKM(arr.length, arr[0].length, arr));
    }

    public KuhnMunkres2(int[][] graph) {
        this.graph = graph;
        this.labels = new int[graph.length];
        this.visited = new boolean[graph.length];
        this.match = new int[graph.length];
        Arrays.fill(this.match, -1);
    }

    public int maxWeightMatching() {
        for (int i = 0; i < graph.length; i++) {
            // find maximum weight in row i
            int maxWeight = Integer.MIN_VALUE;
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > maxWeight) {
                    maxWeight = graph[i][j];
                }
            }
            labels[i] = maxWeight;
        }

        for (int i = 0; i < graph.length; i++) {
            while (true) {
                Arrays.fill(visited, false);
                if (findAugmentingPath(i)) {
                    break;
                } else {
                    // update labels
                    int delta = Integer.MAX_VALUE;
                    for (int j = 0; j < graph.length; j++) {
                        if (visited[j]) {
                            for (int k = 0; k < graph.length; k++) {
                                if (!visited[k]) {
                                    delta = Math.min(delta, labels[j] + labels[k] - graph[j][k]);
                                }
                            }
                        }
                    }
                    for (int j = 0; j < graph.length; j++) {
                        if (visited[j]) {
                            labels[j] -= delta;
                        } else {
                            labels[j] += delta;
                        }
                    }
                }
            }
        }

        int weight = 0;
        for (int i = 0; i < graph.length; i++) {
            if (match[i] != -1) {
                weight += graph[i][match[i]];
            }
        }
        return weight;
    }

    private boolean findAugmentingPath(int i) {
        visited[i] = true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == labels[i] + labels[j] && !visited[j]) {
                visited[j] = true;
                if (match[j] == -1 || findAugmentingPath(match[j])) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
