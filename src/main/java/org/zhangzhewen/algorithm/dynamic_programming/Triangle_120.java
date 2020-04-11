package org.zhangzhewen.algorithm.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Triangle_120
 * https://time.geekbang.org/course/detail/130-69780
 *
 * @author zhangzhewen
 * @date 2020/4/11
 */
public class Triangle_120 {
    public static void main(String[] args) {
      int result =   minimumTotal2(new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(2);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(4);
            }});
            add(new ArrayList<Integer>() {{
                add(6);
                add(5);
                add(7);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(1);
                add(8);
                add(3);
            }});
        }});

        System.out.println(result);
//[
//    [2],
//   [3,4],
//  [6,5,7],
// [4,1,8,3]
// ]
    }
    public static int minimumTotal2(List<List<Integer>> triangle) {
        return recursion(triangle,0,0);
    }

    public static int recursion(List<List<Integer>> triangle,int row,int col){
        if(triangle.size()-1==row){
            return triangle.get(row).get(col);
        }
        return triangle.get(row).get(col) + Math.min(recursion(triangle,row+1,col),recursion(triangle,row+1,col+1));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        // 1.定义状态：DP[i,j]: ①从底部开始i,j ②最小路径和
        // 2.状态转移方程：DP[i,j] = min(DP(i+1,j),DP(i+1,j+1)) + triangle[i,j]
        int[] candidates = new int[triangle.get(triangle.size() - 1).size()];
        for (int i = triangle.get(triangle.size() - 1).size() - 1; i >= 0; i--) {
            candidates[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                candidates[j] = triangle.get(i).get(j) + Math.min(candidates[j], candidates[j + 1]);
            }
        }

        return candidates[0];
    }
}
