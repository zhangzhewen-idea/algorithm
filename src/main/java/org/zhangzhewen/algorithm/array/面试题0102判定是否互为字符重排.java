package org.zhangzhewen.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class 面试题0102判定是否互为字符重排 {

    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return true;
        }
        Map<Character, Integer> map = new HashMap();
        for (char c1 : s1.toCharArray()) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }
        for(char c2 : s2.toCharArray()){
            Integer c1Count = map.get(c2);
            if(c1Count==null || c1Count==0){
                return false;
            }
            map.put(c2,c1Count-1);
        }

        return true;
    }

}
