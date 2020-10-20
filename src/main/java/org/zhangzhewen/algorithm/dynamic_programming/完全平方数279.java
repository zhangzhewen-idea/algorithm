package org.zhangzhewen.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * 完全平方数279
 *
 * @author zhangzhewen
 * @date 2020/10/17
 */
public class 完全平方数279 {


    public static void main(String[] args) {
        new 完全平方数279().numSquares(12);
    }

    /*

    public int numSquares(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    // bottom case
    dp[0] = 0;

    // pre-calculate the square numbers.
    int max_square_index = (int) Math.sqrt(n) + 1;
    int square_nums[] = new int[max_square_index];
    for (int i = 1; i < max_square_index; ++i) {
      square_nums[i] = i * i;
    }

    for (int i = 1; i <= n; ++i) {
      for (int s = 1; s < max_square_index; ++s) {
        if (i < square_nums[s])
          break;
        dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
      }
    }
    return dp[n];
  }

     */

    public int numSquares(int n) {
        boolean[] isSquares = new boolean[n + 1];
        int maxSquareIndex = (int)Math.sqrt(n)+1;
        int[] squareNums = new int[maxSquareIndex];
        for(int i = 1;i<squareNums.length;i++){
            squareNums[i]=i*i;
            isSquares[i*i]=true;
        }


        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if(isSquares[i]){
                dp[i]=1;
            }else{
                int curMin = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++) {
                    if (isSquares[j] && !isSquares[i - j]) {
                        curMin = Math.min(curMin, 1 + dp[i - j]);
                    } else if (!isSquares[j] && isSquares[i - j]) {
                        curMin = Math.min(curMin, 1 + dp[j]);
                    } else if (isSquares[j] && isSquares[i - j]) {
                        curMin = Math.min(curMin, 2);
                    } else {
                        curMin = Math.min(curMin, dp[i - j] + dp[j]);
                    }
                }
                dp[i] = curMin;
            }
        }
        return dp[n];
    }



    /*public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }*/

}
