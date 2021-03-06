package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * 整数拆分343
 *
 * @author zhangzhewen
 * @date 2020/10/17
 */
public class 整数拆分343 {
    public static void main(String[] args) {
        new 整数拆分343().integerBreak(4);
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i = 2;i<=n;i++){
            int curMax = 0;
            for(int j=1;j<i;j++){
                curMax= Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

}
