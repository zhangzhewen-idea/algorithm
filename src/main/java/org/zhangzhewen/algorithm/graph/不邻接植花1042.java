package org.zhangzhewen.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 不邻接植花1042
 * <p>
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 * <p>
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 * <p>
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 *
 * @author zhangzhewen
 * @date 2020/11/5
 */
public class 不邻接植花1042 {

    public static void main(String[] args) {
        new 不邻接植花1042().gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}});
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        // 1.创建邻接表
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < paths.length; i++) {
            adjacencyList[paths[i][0] - 1].add(paths[i][1] - 1);
            adjacencyList[paths[i][1] - 1].add(paths[i][0] - 1);
        }
        // 2.染色
        int[] answer = new int[n];
        for (int i = 0; i < adjacencyList.length; i++) {
            boolean[] color = new boolean[5];
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                color[answer[adjacencyList[i].get(j)]] = true;
            }
            for (int j = 1; j < color.length; j++) {
                if (!color[j]) {
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }

    /*

    解题思路
首先，使用邻接矩阵的话，亲测，会堆栈溢出，遂改为邻接表法。
1、根据paths建立邻接表；
2、默认所有的花园先不染色，即染0；
3、从第一个花园开始走，把与它邻接的花园的颜色从color{1,2,3,4}这个颜色集中删除；
4、删完了所有与它相邻的颜色，就可以把集合中剩下的颜色随机选一个给它了，为了简单，将集合中的第一个颜色赋给当前花园；
5、循环3和4到最后一个花园。

    class Solution {
    public:
        //static const int MAXV=10000;
        //int G[MAXV][MAXV]={0};
        vector<int> gardenNoAdj(int N, vector<vector<int>>& paths) {
            vector<int> G[N];
            for (int i=0; i<paths.size(); i++){//建立邻接表
                G[paths[i][0]-1].push_back(paths[i][1]-1);
                G[paths[i][1]-1].push_back(paths[i][0]-1);
            }
            vector<int> answer(N,0);//初始化全部未染色
            for(int i=0; i<N; i++){
                set<int> color{1,2,3,4};
                for (int j=0; j<G[i].size(); j++){
                    color.erase(answer[G[i][j]]);//把已染过色的去除
                }
                answer[i]=*(color.begin());//染色
            }
            return answer;
        }
    };
     */
}
