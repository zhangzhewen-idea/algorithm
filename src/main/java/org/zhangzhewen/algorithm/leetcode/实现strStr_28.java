package org.zhangzhewen.algorithm.leetcode;

/**
 * 实现strStr_28
 * https://leetcode-cn.com/problems/implement-strstr/
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * <p>
 * KMP：
 * 学习要点：如果知道了为什么可以跳跃式比较，还有为什么可以直接跳跃到这个位置，就明白了的kmp了。
 * kmp的重要数据结构：最长的公共前缀和后缀（Longest Prefix and Suffix，简称LPS），它是一个数组，记录了字符串从头开始到某个位置结束的一段字符串中，公共前缀和后缀的最大长度
 * 公共前缀和后缀，即字符串的前缀等于后缀，（限制：前缀和后缀不能是同一段字符串）
 *
 * @author zhangzhewen
 * @date 2020/9/10
 */
public class 实现strStr_28 {

    public static void main(String[] args) {
//        System.out.println(strStr("hello", "ll"));
//        System.out.println(strStr("abcdefghijk", "fghi"));
        System.out.println(strStr("abc1abac1abcc", "abc1abc"));
    }


    // KMP
    public static int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (needleLen == 0) {
            return 0;
        }
        // 求出needle的LPS，即最长的公共前缀和后缀数组
        int[] lps = getLPS(needle);
        // 定义指针i用来扫描haystack
        // 定义指针j用来扫描needle
        int haystackIndex = 0, needleIndex = 0;

        // 进入循环体，直到i扫描完整个haystack，一旦扫描完还没有发现needle，则跳出循环
        while (haystackIndex < haystackLen) {
            // 在循环体中，当发现i指针与j指针指向的字符相等时，两个指针一起向前走一步 haystackIndex++, needleIndex++
            if (haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
                haystackIndex++;
                needleIndex++;

                // 一旦发现j已经扫描完needle字符串，说明已在haystack中找到了needle，立即返回它在haystack中的起始位置
                if (needleIndex == needleLen) {
                    return haystackIndex - needleLen;
                }
            }
            // 在循环体中，当发现haystackIndex指针与needleIndex指针指向的字符不相同时，尝试进行跳跃操作j=LPS[needleIndex-1]，这里必须判断needleIndex是否大于0
            else if (needleIndex > 0) {
                needleIndex = lps[needleIndex - 1];
            }
            // needleIndex等于0的情况，表明此时needle的第一个字符已不同于haystack的字符，尝试对比haystack的下一个字符，故haystackIndex++
            else {
                haystackIndex++;
            }
        }

        // 最终，若未能在haystack中找到needle，返回-1
        return -1;
    }

    static int[] getLPS(String str) {
        // 初始化一个LPS数组用来保存最终的结果
        int[] lps = new int[str.length()];
        // 由于LPS的第一个值一定为0，即长度为1的字符串的最长公共前缀后缀的长度为0，直接从第二个位置遍历，
        // 并初始化当前最长的LPS长度为0，用len变量记录一下
        int i = 1, len = 0;
        // 指针i遍历整个输入字符串
        while (i < str.length()) {
            // 如果i指针能够延续前缀和后缀，更新LPS值为len+1
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            }
            // 否则，判断len是否大于0，然后尝试第二长的前缀和后缀，看看是否能继续延续
            else if (len > 0) {
                len = lps[len - 1];
            }
            // 尝试了所有的前缀和后缀都不行时，则当前的LPS为0，i++
            else {
                i++;
            }
        }
        // 最后返回LPS数组
        return lps;
    }

    /*// 暴力法：时间复杂度 O(m*n)
    public static int strStr(String haystack, String needle) {
        // 定义一个i指针，用来遍历haystack字符串
        for (int i = 0; ; i++) {
            // 对于每一个i指针，用另外一个j指针来扫描needle字符串
            for (int j = 0; ; j++) {
                // 如果j扫描完毕，表示在haystack字符串中找到了needle字符串
                if (j == needle.length()) {
                    return i;
                }
                // 如果i扫描完毕，表示无法在haystack字符串中找到needle字符串，返回-1
                if (i + j == haystack.length()) {
                    return -1;
                }
                // 如果要比较的两个字符不相等，则跳出内循环，i指针向前挪一个位置，继续刚才的比较
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }


    // 自己写的
    public static int strStr2(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if ((i + needle.length() >= haystack.length())) {
                return -1;
            }
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean match = true;
                for (int j = 1; j < needle.length(); j++) {
                    if ((i + j >= haystack.length()) || haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }
*/

}
