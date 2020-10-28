package org.zhangzhewen.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 面试题1714最小K个数
 *
 * @author zhangzhewen
 * @date 2020/10/28
 */
public class 面试题1714最小K个数 {
    public static void main(String[] args) {

    }
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : arr){
            heap.offer(i);
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
