package org.zhangzhewen.algorithm.tree;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author zhangzhewen
 * @date 2020/9/30
 */
public class 最小路径和64 {

    public static void main(String[] args) {
        new 最小路径和64().minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
    }

    /* 时间复杂度和空间复杂度都是 O(mn) */
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    /*  自己写的时间复杂度O(2^n)
    public int minPathSum(int[][] grid) {
        return helper(grid,0,0,0);
    }

    int helper(int[][] grid,int row,int col,int sum){
        if(row>=grid.length||row<0||col>=grid[0].length||col<0){
            return Integer.MAX_VALUE;
        }
        sum+=grid[row][col];
        if(col==grid[0].length-1&&row==grid.length-1){
            return sum;
        }

        return min(
            helper(grid,row+1,col,sum),
            helper(grid,row,col+1,sum)
        );
    }*/


    private int min(int... num){
        int min = num[0];
        for(int i = 1;i < num.length;i++){
            if(num[i]<min){
                min = num[i];
            }
        }
        return min;
    }


}
