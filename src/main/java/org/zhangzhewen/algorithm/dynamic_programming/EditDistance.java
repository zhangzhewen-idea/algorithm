package org.zhangzhewen.algorithm.dynamic_programming;

import org.zhangzhewen.algorithm.Utils;

/**
 * EditDistance
 * todo 需要熟练掌握，很经典地用dp处理字符串匹配问题。需要经常练习，特别是面试前。
 * https://time.geekbang.org/course/detail/130-69785
 * https://leetcode-cn.com/problems/edit-distance/submissions/
 *
 * @author zhangzhewen
 * @date 2020/5/12
 */
public class EditDistance {
    public static void main(String[] args) {
//        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("arise", "rise"));
    }

    public int minDistance(String word1, String word2) {

        int word1Length = word1.length();
        int word2Length = word2.length();

        //  ①状态定义：DP[i][j] -> word1前i个字符 到 word2前j个字符最少步数
        // 最后 DP[m][n]就是word1匹配到word2最少步数
        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int i = 0; i < word1Length + 1; i++) {
            // word1前i个字符全部删除才会等于word2的空字符
            dp[i][0] = i;
        }
        for (int j = 0; j < word2Length + 1; j++) {
            // word2前j个字符全部删除才会等于word1的空字符
            dp[0][j] = j;
        }

        // 从 word1的第1个字符，和word2的第1个字符开始
        for (int i = 1; i < word1Length + 1; i++) {
            for (int j = 1; j < word2Length + 1; j++) {
                //  ②状态转移方程定义：
                dp[i][j] = min(
                        // 对应替换
                        dp[i - 1][j - 1] +
                                // word1前i个字符和word2前j个字符相等 则不需要任何操作，否则对应 一次替换操作
                                ((word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)),

                        // 对应增
                        dp[i - 1][j] + 1,

                        // 对应删
                        dp[i][j - 1] + 1
                );
            }
        }
        return dp[word1Length][word2Length];
    }

    public static int min(int... a) {
        int min = a[0];
        for (int i : a) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}

