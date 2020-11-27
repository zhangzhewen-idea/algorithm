package org.zhangzhewen.algorithm.hashtable;

import java.util.*;

public class 剑指Offer48最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        new 剑指Offer48最长不含重复字符的子字符串().lengthOfLongestSubstring("abba");
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }


    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int ans = 0, l = 0, r = 0;
        Map<Character, Integer> charAndIndexMap = new HashMap();
        while (r < s.length()) {
            Integer duplicateIndex = charAndIndexMap.get(chars[r]);
            if (duplicateIndex != null) {
                l = duplicateIndex + 1;
                Iterator<Map.Entry<Character, Integer>> ite = charAndIndexMap.entrySet().iterator();
                while (ite.hasNext()) {
                    Map.Entry<Character, Integer> entry = ite.next();
                    if (l > entry.getValue()) {
                        ite.remove();
                    }
                }
            }
            charAndIndexMap.put(chars[r], r);
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
