package org.zhangzhewen.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

public class 最长回文串409 {
    public static void main(String[] args) {
        new 最长回文串409().longestPalindrome("abccccdd");
        new 最长回文串409().longestPalindrome("abccccdd");
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> charAndCount = new HashMap();
        for (char c : s.toCharArray()) {
            charAndCount.put(c, charAndCount.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        boolean odd = false;
        for (Integer count : charAndCount.values()) {
            if ((count & 1) == 0) {
                ans += count;
            } else {
                odd = true;
            }
        }
        return odd ? ans + 1 : ans - 1;
    }
}
