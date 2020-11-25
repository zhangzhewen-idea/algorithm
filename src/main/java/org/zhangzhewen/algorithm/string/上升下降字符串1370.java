package org.zhangzhewen.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 上升下降字符串1370 {
    public static void main(String[] args) {
//        new 上升下降字符串1370().sortString("aaaabbbbcccc");
        new 上升下降字符串1370().sortString("leetcode");
    }


    public String sortString(String s) {
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        while (ans.length() < s.length()) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i]-- > 0) {
                    ans.append((char) (i + 'a'));
                }
            }
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i]-- > 0) {
                    ans.append((char) (i + 'a'));
                }
            }
        }
        return ans.toString();
    }

    public String sortString2(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        // nlogn
        Arrays.sort(chars);
        List<Integer> pointList = new LinkedList<>();
        char curChar = chars[0];
        pointList.add(0);
        // n
        for (int i = 0; i < chars.length; i++) {
            if (curChar != chars[i]) {
                pointList.add(i);
                curChar = chars[i];
            }
        }
        int[] pointArray = new int[pointList.size()];
        for (int i = 0; i < pointArray.length; i++) {
            pointArray[i] = pointList.get(i);
        }
        while (sb.length() < s.length()) {
            for (int i = 0; i < pointArray.length; i++) {
                if ((i + 1 < pointArray.length && pointArray[i] < pointList.get(i + 1) || (i + 1 == pointArray.length && pointArray[i] < chars.length))) {
                    sb.append(chars[pointArray[i]++]);
                }
            }
            if (sb.length() < s.length()) {
                for (int i = pointArray.length - 1; i >= 0; i--) {
                    if ((i + 1 < pointArray.length && pointArray[i] < pointList.get(i + 1)) || (i + 1 == pointArray.length && pointArray[i] < chars.length)) {
                        sb.append(chars[pointArray[i]++]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
