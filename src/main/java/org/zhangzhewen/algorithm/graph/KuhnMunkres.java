package org.zhangzhewen.algorithm.graph;

import java.util.Arrays;

public class KuhnMunkres {

    public static void main(String[] args) {
        /*
            示例请参照：https://blog.csdn.net/qq_37457202/article/details/80161274
        */
        int[][] arr = new int[][]{
                {3,-1,4},
                {2,1,3},
                {0,0,5}
        };

        int[][] arr2 = new int[][]{
                {3,2,0},
                {3,0,1},
                {0,0,0}
        };
        new Km().calc(arr);
        System.out.println(new KuhnMunkresAlgorithm().getKM(arr.length, arr[0].length, arr));
    }

    /*
    dfs教程：https://leetcode.cn/problems/campus-bikes-ii/solutions/808042/zhuang-tai-ya-suo-dp-xiong-ya-li-suan-fa-l6ui/?q=km&orderBy=most_relevant
    bfs教程：https://leetcode.cn/problems/campus-bikes-ii/solutions/1262960/on3-xiong-ya-li-suan-fa-km-suan-fa-fu-ja-sb4z/?q=km&orderBy=most_relevant

    */
    static class KuhnMunkresAlgorithm {

        private int[][] weights; // 无向图中的权重
        private int[] lx;  // 二分图左半边的顶标
        private int[] ly;  // 二分图右边的顶标
        private boolean[] sx; // 二分图左半边 顶点是否在最终结果中
        private boolean[] sy; // 二分图右半边 顶点是否在最终结果中
        private int[] match;  // match[y] = x 记录右半边 y 是和哪个 x match

        // 此实现是dfs，可以用bfs
        public int getKM(int m, int n, int[][] values) {
            this.weights = values;
            this.lx = new int[m];
            this.ly = new int[n];
            this.sx = new boolean[m];
            this.sy = new boolean[n];
            this.match = new int[n];
            Arrays.fill(match, -1);
            // 1. 初始化顶标
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    lx[i] = Math.max(lx[i], values[i][j]);
                }
            }

            // 2. 对于左图，在满足顶标之和的子图上依次遍历 （左图去匹配右图）
            for (int i = 0; i < m; i++) {
                while (true) {
                    // 这就相当于匈牙利算法中的used数组，每次探索增广路径前默认都未访问
                    Arrays.fill(sx, false);
                    Arrays.fill(sy, false);
                    if (findAugmentPath(i)) {
                        break;
                    }
                    // 3. 如果子图不能找到增广路径。
                    // 根据现在未成功的扩张路上的顶点，调整顶标。
                    int min = Integer.MAX_VALUE;
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < n; y++) {
                            // 冲突的定义是: x被访问 但那些y未被访问的，
                            // 我们通过尽可能少的降低 x的顶标，提高y的顶标，
                            // 来使得更多的weight 被加入考虑
                            if (sx[x] && !sy[y]) {
                                min = Math.min(min, lx[x] + ly[y] - weights[x][y]);
                            }
                        }
                    }

                    // 4. 调整顶标，同步调整y的意义 是让之前的那些边还仍被考虑。
                    for (int x = 0; x < m; x++) {
                        if (sx[x]) {
                            lx[x] -= min;
                        }
                    }
                    for (int y = 0; y < n; y++) {
                        if (sy[y]) {
                            ly[y] += min;
                        }
                    }
                }
            }

            // 5. 找到最大匹配。
            int sum = 0;
            for (int y = 0; y < n; y++) {
                if (match[y] == -1) {
                    continue;
                }
                // 这里可以打印具体匹配细节。
                System.out.println("x: " + match[y] + " <-----------> y: " + y +
                 " ,value: " + weights[match[y]][y]);
                sum += weights[match[y]][y];
            }
            return sum;
        }

        private boolean findAugmentPath(int i) {
            sx[i] = true;
            int n = weights[0].length;
            for (int j = 0; j < n; j++) {
                if (!sy[j] && lx[i] + ly[j] == weights[i][j]) {// 右未匹配点 且 左右顶标的和等于权重。
                    sy[j] = true;
                    if (match[j] == -1 || findAugmentPath(match[j])) {// 左右两点未匹配，进行匹配；左右两点匹配，寻找增广路径。
                        match[j] = i;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /*
     leetcode题目：https://leetcode.cn/problems/campus-bikes-ii/description/
     用到了km算法。
     */
    public int assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length;
        int n = bikes.length; // (m <= n)
        int[][] values = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int manhattan = Math.abs(workers[i][0] - bikes[j][0])
                        + Math.abs(workers[i][1] - bikes[j][1]);
                values[i][j] = 0 - manhattan;
            }
        }
        KuhnMunkresAlgorithm km = new KuhnMunkresAlgorithm();
        int maxDis = km.getKM(m, n, values);
        return 0 - maxDis;
    }

    /*
    自己练习的
     */
    static class Km{
        private int[][] weights;
        private int[] lx,ly;
        private boolean[] sx,sy;
        private int[] matches;
        public int calc(int[][] o ){

            weights = o;
            lx = new int[weights.length];
            ly = new int[weights.length];
            sx = new boolean[weights.length];
            sy = new boolean[weights.length];
            matches = new int[weights.length];
            Arrays.fill(matches,-1);

            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j < weights.length; j++) {
                    lx[i] = Math.max(lx[i],weights[i][j]);
                }
            }

            for (int i = 0; i < weights.length; i++) {
                while(true){
                    Arrays.fill(sx,false);
                    Arrays.fill(sy,false);
                    if(augment(i)){
                        break;
                    }
                    int delta = Integer.MAX_VALUE;
                    for (int j = 0; j < weights.length; j++) {
                        for (int k = 0; k < weights.length; k++) {
                            if(sx[j]&&!sy[k]){
                                delta = Math.min(delta,lx[j]+ly[k]-weights[j][k]);
                            }
                        }
                    }
                    for (int j = 0; j < weights.length; j++) {
                        if(sx[j]){
                            lx[j]-=delta;
                        }
                        if(sy[j]){
                            ly[j]+=delta;
                        }
                    }
                }
            }
            int sum =0;
            for (int i = 0; i < weights.length; i++) {
                sum += weights[matches[i]][i];
                System.out.println("x:"+matches[i]+" to y:"+i+" weight:"+weights[matches[i]][i]);
            }
            return sum;
        }

        private boolean augment(int i) {
            sx[i]=true;
            for (int j = 0; j < weights.length; j++) {
                if(!sy[j]&&lx[i]+ly[j]==weights[i][j]){
                    sy[j]=true;
                    if(matches[j]==-1||augment(matches[j])){
                        matches[j]=i;
                        return true;
                    }
                }
            }
            return false;
        }

    }


}



