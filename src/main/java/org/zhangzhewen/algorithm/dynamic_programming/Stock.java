package org.zhangzhewen.algorithm.dynamic_programming;

import java.util.Map;

/**
 * Stock
 * todo 需要完成leetcode 121 122 123 309 188 714
 *
 * @author zhangzhewen
 * @date 2020/4/12
 */
public class Stock {
    public static void main(String[] args) {
        // 动态规划
        // 1.定义状态
        // 2.定义状态转移方程

//        System.out.println(new Stock().maxProfit(2,new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Stock().maxProfit(2,new int[]{2,4,1}));
//        System.out.println(new Stock().maxProfit2(new int[]{1,2,3,4,5}));
    }


    public int maxProfit(int k, int[] prices) {

        //
        // 这个算法还是空间复杂度比较高，可以用状态压缩，具体可见⏬：
        // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/dong-tai-gui-hua-by-liweiwei1419-4/
        if(prices.length <= 1){
            return 0;
        }else{
            int maxProf = 0;
            int[][] f = new int[k+1][prices.length];
            for(int kk = 1; kk <= k; kk++){
                int tmpMax = f[kk-1][0] - prices[0];
                for (int ii = 1; ii < prices.length; ii++) {
                    f[kk][ii] = Math.max(f[kk][ii-1],prices[ii]+tmpMax);
                    tmpMax = Math.max(tmpMax,f[kk-1][ii]-prices[ii]);
                    maxProf = Math.max(f[kk][ii],maxProf);
                }
            }
            return maxProf;
        }


    }

    /*
        leetcode 121
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
        买入卖出股票最多一次
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.定义状态：dp[天数][0:未买 1:已买 2:已买]
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            // 2.定义状态转移方程
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];

            res = Math.max(Math.max(dp[i][0], dp[i][2]), res);
        }

        return res;
    }
    public int maxProfit2(int[] prices) {

        int[][][] dp = new int[prices.length][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0]=dp[i-1][0][0];
            dp[i][0][1]=Math.max(dp[i-1][0][1],dp[i-1][0][0]-prices[i]);

            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][0][1]+prices[i]);
            dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][1][1]-prices[i]);

            dp[i][2][0]=Math.max(dp[i-1][2][0],dp[i-1][1][1]+prices[i]);

        }

        return Math.max(dp[dp.length-1][0][0],Math.max(dp[dp.length-1][1][0],dp[dp.length-1][2][0]));
    }
    /*
        leetcode 122
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
        买入卖出股票无限次
     */
    public int maxProfit3(int[] prices) {

        //动态规划
        // 1.定义状态：dp[天数][可以买卖的次数,0:无限多次][0:未买 1:已买 2:已买]
        int k = 2;
        int[][][] dp = new int[prices.length][k+1][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int kk = 1; kk <= k; kk++) {
            dp[0][kk][0] = Integer.MIN_VALUE;
            dp[0][kk][1] = Integer.MIN_VALUE;
        }
        int res = 0;
        // 2.定义状态转移方程
        for (int i = 1; i < prices.length; i++) {
            for (int kk = 0; kk <= k; kk++) {
                if (kk == 0) {
                    dp[i][kk][0] = dp[i - 1][kk][0];
                    dp[i][kk][1] = Math.max(dp[i - 1][kk][1], dp[i - 1][kk][0] - prices[i]);
                } else {
                    dp[i][kk][0] = Math.max(dp[i - 1][kk][0], dp[i - 1][kk - 1][1] + prices[i]);
                    if(Integer.MIN_VALUE!=dp[i - 1][kk][0]) {
                        dp[i][kk][1] = Math.max(dp[i - 1][kk][1], dp[i - 1][kk][0] - prices[i]);
                    }
                }

                res = Math.max(dp[i][kk][0], res);
            }
        }
        return res;




        // Greedy algorithm
        /*int profit = 0;
        Integer pre = null;
        for(int i = 0 ; i < prices.length ; i++){
            if(pre != null && pre<prices[i]){
                profit += prices[i] - pre ;
            }
            pre = prices[i];
        }
        return profit;*/
    }
}
