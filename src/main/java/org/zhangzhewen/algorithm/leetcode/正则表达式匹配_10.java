package org.zhangzhewen.algorithm.leetcode;

/**
 * 正则表达式匹配_10
 * todo 可能有问题
 *
 * @author zhangzhewen
 * @date 2020/9/9
 */
public class 正则表达式匹配_10 {

    public static void main(String[] args) {
        isMatch("aa", "a");
    }

    // 动态规划 - 自底向上
    // 复杂度分析：运用动态规划，我们把时间复杂度控制在O(n^2)，空间复杂度也是O(n^2)
    static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // 定义一个二维布尔矩阵dp
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化dp[0][0]等于true，表示当两字符串长度都为0，也就是空字符串时，它们互相匹配
        dp[0][0] = true;
        // 【重要】初始化二维矩阵第一行的所有值：
        // -当s为空字符串时，对p字符串的任一位置，要使得这个位置的子串能和空字符串匹配，要求，这个子串都是由一系列的星号组合构成
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        // 对二维矩阵填表：逻辑与递归一样
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p的当前字符不是星号时，判断当前两字符是否相等，如果相等，则看看dp[i-1][j-1]的值，因为它保存了前一个匹配的结果。
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(s.charAt(i - 1), p.charAt(j - 1));
                }
                // 当p的当前字符是星号时，进行两种尝试：
                // -用星号组合表示空字符串，看看是否能匹配，即dp[i][j-2]
                // -用星号组合表示一个字符，看看是否能匹配，即dp[i-1][j]
                else {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && isMatch(s.charAt(i - 1), p.charAt(j - 2));
                }
            }
        }

        return dp[m][n];
    }

    static boolean isMatch(char a, char b) {
        return a == b || b == '.';
    }

 /*
    static boolean isMatch(String s, String p) {
        // 简单判断：只要s和p有一个为null，则不匹配
        if (s == null || p == null) {
            return false;
        }

        // 调用递归函数：指针i和j都指向0的位置
        return isMatch(s, 0, p, 0);
    }

    // 函数接受四个输入参数： s字符串，p字符串，i指针，j指针
    static boolean isMatch(String s, int i, String p, int j) {
        // 一开始计算一下s字符串和p字符串的长度，分别标记为m和n
        int m = s.length();
        int n = s.length();

        //看看pattern和字符串是否都扫描完毕
        //考虑递归函数结束的时间：
        //当j指针遍历完p字符串后，即可跳出递归，而当i指针也刚好遍历完，说明s和p完全匹配
        if (j == n) {
            return i == m;
        }

        // next char is not '*':必须满足当前字符并递归到下一层
        // 接下来看看j指针的下一个是否为星号，如果不是星号，则递归地调用isMatch函数
        if (j == n - 1 || p.charAt(j + 1) != '*') {
            return (i < m) &&
                    // 如果j指向的字符下一个为星号，则不断地将它和星号作为一个整体，分别表示空字符串，一个j指向的字符，两个字符，以此类推。
                    // 如果其中一种情况能出现s和p匹配，则返回true
                    (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && isMatch(s, i + 1, p, j + 1);
        }

        // next char is '*',如果有连续的s[i]出现并且都等于p[j]，一直尝试下去
        // while循环 - 整个递归算法的核心
        // - i指向的字符必须要能和j指向的字符匹配，其中j指向的可能是点匹配符
        // - 如果无法匹配，则i++，表示用星号组合去匹配更长的一段字符串
        if (j < n - 1 && p.charAt(j + 1) == '*') {
            while ((i < m) && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))) {
                if (isMatch(s, i, p, j + 2)) {
                    return true;
                }
                i++;
            }
        }

        // 接着继续下去
        // 当i与j指向的字符不相同，或i已遍历完s字符串，同事j指向的字符后跟着一个星号的情况，
        // 我们只能用星号组合去表示一个空字符串，然后递归下去
        return isMatch(s, i, p, j + 2);
    }*/

}
