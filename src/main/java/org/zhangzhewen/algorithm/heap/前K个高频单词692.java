package org.zhangzhewen.algorithm.heap;

import java.util.*;

/**
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 * <p>
 * 扩展练习：
 * <p>
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * @author zhangzhewen
 * @date 2020/10/28
 */
public class 前K个高频单词692 {

    public static void main(String[] args) {
        new 前K个高频单词692().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> check = new HashSet();
        for (int v : map.values()) {
            if (check.contains(v)) {
                return false;
            }
            check.add(v);
        }
        return true;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>(k,
                (a, b) -> {
                    int frequent = (map.get(b) - map.get(a));
                    return frequent == 0 ? b.compareTo(a) : frequent;
                }
        );
        for (String word : map.keySet()) {
            maxHeap.offer(word);
        }
        List<String> res = new ArrayList<>();
        while (k-- > 0) {
            res.add(maxHeap.poll());
        }
        return res;
    }

}
