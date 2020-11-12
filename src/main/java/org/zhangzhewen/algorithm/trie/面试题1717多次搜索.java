package org.zhangzhewen.algorithm.trie;

import java.util.*;

public class 面试题1717多次搜索 {
    public static void main(String[] args) {
        new 面试题1717多次搜索().multiSearch("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});
    }

    public int[][] multiSearch(String big, String[] smalls) {
        if(smalls.length==0|| smalls[0].length()==0){
            return new int[1][0];
        }
        Set<Integer>[] res = new TreeSet[smalls.length];
        for (int i = 0; i < smalls.length; i++) {
            res[i] = new TreeSet<>();
        }
        Trie trie = new Trie(smalls, big);
        int maxCol = Integer.MIN_VALUE;
        for (int i = 0; i < big.length(); i++) {
            for(Integer pos : trie.find(big.substring(i))){
                res[pos].add(i);
                maxCol = Math.max(maxCol,res[pos].size());
            }
        }
        int[][] answer = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            int[] aux = new int[res[i].size()];
            int j = 0;
            for (int ids : res[i]) {
                aux[j++] = ids;
            }
            answer[i] = aux;
        }
        return answer;
    }

    class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;
        String big;
        Integer pos;
        char c = ' ';

        Trie() {
        }

        Trie(String[] smalls, String big) {
            this.big = big;
            for (int i = 0; i < smalls.length; i++) {
                insert(smalls[i], i);
            }
        }

        void insert(String smalls, int pos) {
            Trie root = this;
            for (char c : smalls.toCharArray()) {
                if (root.children[c - 'a'] == null) {
                    root.children[c - 'a'] = new Trie();
                }
                root = root.children[c - 'a'];
                root.c = c;
            }
            root.isWord = true;
            root.pos = pos;
        }

        List<Integer> find(String sub) {
            List<Integer> res = new ArrayList<>();
            Trie root = this;
            for (char c : sub.toCharArray()) {
                if (root.isWord) {
                    res.add(root.pos);
                }
                root = root.children[c - 'a'];
                if (root == null) {
                    return res;
                }
            }
            if (root.isWord) {
                res.add(root.pos);
            }
            return res;
        }
    }
}
