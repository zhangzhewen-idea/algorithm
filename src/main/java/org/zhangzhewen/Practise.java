package org.zhangzhewen;


import org.zhangzhewen.algorithm.MergeKLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * t
 *
 * @author zhangzhewen
 * @date 2020/6/12
 */
public class Practise {
    public static void main(String[] args) {
//        System.out.println(new t().minDistance("arise", "rise"));

        Practise p = new Practise();
        TreeNode _1 = p.new TreeNode(1);
        TreeNode _2 = p.new TreeNode(2);
        TreeNode _3 = p.new TreeNode(3);
        TreeNode _4 = p.new TreeNode(4);
        TreeNode _5 = p.new TreeNode(5);
        TreeNode _6 = p.new TreeNode(6);
        TreeNode _7 = p.new TreeNode(7);

        _1.left = _2;
        _1.right = _3;
        _2.left = _4;
        _2.right = _5;
        _3.left = _6;
        _3.right = _7;

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList() {{
            add(2);
        }});
        res.add(new ArrayList() {{
            add(3);
            add(4);
        }});
        res.add(new ArrayList() {{
            add(6);
            add(5);
            add(7);
        }});
        res.add(new ArrayList() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }});


//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));


//        System.out.println(maxProduct(new int[]{2,3,-2,4}));

//        System.out.println(majorityElement(new int[]{3,2,3}));


//        p.isValidBST(_1);

//        System.out.println(numIslands(new char[][]{{'1','0'},{'0','1'}}));


//        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
//        System.out.println(coinChange(new int[]{1,2,5},11));

//        System.out.println(fib(7));

        /*PriorityQueue<Integer> pp = new PriorityQueue<Integer>(3);
        pp.add(9);
        pp.add(10);
        pp.add(50);

        KthLargest a = new KthLargest(3,new int[]{4,5,8,2});
        System.out.println();*/

        Practise p1 = new Practise();
//        p1.lengthOfLongestSubstring("abba");

//        p1.removeElement(new int[]{2, 2, 3}, 2);
//        p1.findMedianSortedArrays(new int[]{1, 2,6},new int[]{3,4,5,7,8,9,10,11,12,13,14,15,16,17,18,19});


//        int[] arr = new int[]{5,3,1,2,6,9,8,7,20};
//        int k = 3;
//        System.out.println(p1.kuaipaiGetK(arr,4,0,arr.length-1));


    }

    public int eraseOverlapIntervals(int[][] intervals) {

        return 0;
    }



    /*

     */

    static class KthLargest {

        private PriorityQueue<Integer> priorityQueue;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(val);
            } else if (priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
            return priorityQueue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */


    public static int min(int... a) {
        int min = a[0];
        for (int i : a) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static int max(int... a) {
        int max = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
