package org.zhangzhewen.algorithm.array;

import java.util.Arrays;

public class 拼写单词1160 {

    public static void main(String[] args) {

    }

    public int countCharacters(String[] words, String chars) {
        int[] charArr = new int[26];
        for (char c : chars.toCharArray()) {
            charArr[c - 'a']++;
        }
        int sum = 0;
        for (String word : words) {
            int[] copyOfCharArr = Arrays.copyOf(charArr, charArr.length);
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (copyOfCharArr[c - 'a']-- <= 0) {
                    valid = false;
                    break;
                }
            }
            if(valid){
                sum += word.length();
            }
        }
        return sum;
    }

}
