package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * EditDistance
 * todo 需要熟练掌握，很经典地用dp处理字符串匹配问题。
 * https://time.geekbang.org/course/detail/130-69785
 * https://leetcode-cn.com/problems/edit-distance/submissions/
 * @author zhangzhewen
 * @date 2020/5/12
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {

        int word1Length = word1.length();
        int word2Length = word2.length();

        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int i = 0; i < word1Length + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2Length + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1Length + 1; i++) {
            for (int j = 1; j < word2Length + 1; j++) {
                dp[i][j] = Math.min(
                        Math.min(
                                // 对应替换
                                dp[i - 1][j - 1] + ((word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)),
                                // 对应增
                                dp[i - 1][j] + 1),
                        // 对应删
                        dp[i][j - 1] + 1
                );
            }
        }
        return dp[word1Length][word2Length];
    }
}
