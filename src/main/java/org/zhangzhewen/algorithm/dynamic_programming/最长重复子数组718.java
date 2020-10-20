package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * 最长重复子数组718
 *
 * @author zhangzhewen
 * @date 2020/10/17
 */
public class 最长重复子数组718 {

    public static void main(String[] args) {
        new 最长重复子数组718().findLength(
                new int[]{
                        1,2,3,2,1
                },
                new int[]{
                        3,2,1,4,7
                }
        );
    }

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int [A.length+1][B.length+1];
        int max = 0;

        for(int i = 1;i<=A.length;i++){
            for(int j = 1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }

}
