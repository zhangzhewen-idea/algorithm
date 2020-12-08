package org.zhangzhewen.algorithm.bit;

/**
 * 找不同389
 *给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 使用异或运算可以解题主要因为异或运算有以下几个特点：
 *
 * 一个数和0做XOR运算等于本身：a⊕0 = a
 * 一个数和其本身做XOR运算等于 0：a⊕a = 0
 * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
 * 异或运算： x ^ 0 = x, x ^ 1 = ~x
 * 与运算： x & 0 = 0, x & 1 = x
 *
 * @author zhangzhewen
 * @date 2020/10/29
 */
public class 找不同389 {

    public static void main(String[] args) {
        new 找不同389().findTheDifference("abcd","abcde");
    }

    public char findTheDifference(String s, String t) {
        char lackChar = 0;
        for(char c : s.toCharArray()){
            lackChar ^= c;
        }
        for(char c: t.toCharArray()){
            lackChar ^= c;
        }
        return lackChar;
    }

}
