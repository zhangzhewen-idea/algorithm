package org.zhangzhewen.algorithm.memory;

import java.util.ArrayList;
import java.util.List;

public class 面试题1713恢复空格 {

    public static void main(String[] args) {
//        new 面试题1713恢复空格().respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother");
        new 面试题1713恢复空格().respace(new String[]{"vprkj", "sqvuzjz", "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp", "spqzqtrqs", "rkktkruzsjkrzqq", "rk", "k", "zkvdzqrzpkrukdqrqjzkrqrzzkkrr", "pzpstvqzrzprqkkkd", "jvutvjtktqvvdkzujkq", "r", "pspkr", "tdkkktdsrkzpzpuzvszzzzdjj", "zk", "pqkjkzpvdpktzskdkvzjkkj", "sr", "zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu"},
                "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr");
    }

    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie(dictionary);
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            Integer skipIndex = trie.findWord(sentence.substring(i));
            if (skipIndex != null) {
                i += skipIndex;
            } else {
                count++;
            }
        }
        return count;
    }

    static class Trie {
        Trie[] children = new Trie[26];
        char c = ' ';
        boolean isWord = false;
        int index = 0;

        public Trie(char c) {
            this.c = c;
        }

        public Trie(String[] dictionary) {
            for (String word : dictionary) {
                insert(word);
            }
        }

        void insert(String word) {
            Trie root = this;
            int i = 0;
            for (char c : word.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new Trie(c);
                }
                root = root.children[c - 'a'];
                root.index = i;
                i++;
            }
            root.isWord = true;
        }

        Integer findWord(String word) {
            Trie root = this;
            for (char c : word.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    break;
                }
                root = root.children[c - 'a'];
                if (root.isWord) {
                    return root.index;
                }
            }
            return null;
        }
    }

}
