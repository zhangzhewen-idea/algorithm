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
 *
 * @author zhangzhewen
 * @date 2020/9/10
 */
public class 实现strStr_28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }

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


}
