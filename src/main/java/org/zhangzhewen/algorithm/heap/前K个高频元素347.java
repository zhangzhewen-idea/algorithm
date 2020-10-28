package org.zhangzhewen.algorithm.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前K个高频元素347
 *
 * @author zhangzhewen
 * @date 2020/10/28
 */
public class 前K个高频元素347 {

    public static void main(String[] args) {
        new 前K个高频元素347().topKFrequent(new int[]
                        {5, 1, -1, -8, -7, 8, -5, 0, 1, 10, 8, 0, -4, 3, -1, -1, 4, -5, 4, -3, 0, 2, 2, 2, 4, -2, -4, 8, -7, -7, 2, -8, 0, -8, 10, 8, -8, -2, -9, 4, -7, 6, 6, -1, 4, 2, 8, -3, 5, -9, -3, 6, -8, -5, 5, 10, 2, -5, -1, -5, 1, -3, 7, 0, 8, -2, -3, -1, -5, 4, 7, -9, 0, 2, 10, 4, 4, -4, -1, -1, 6, -8, -9, -1, 9, -9, 3, 5, 1, 6, -1, -2, 4, 2, 4, -6, 4, 4, 5, -5},
                7);
    }

    // 基于快排-------------------
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // sort[][0]=排序的数字 sort[][1]=数字的个数
        int[][] sort = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sort[idx][0] = entry.getKey();
            sort[idx][1] = entry.getValue();
            idx++;
        }
        quickSort(sort, k, 0, sort.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = sort[i][0];
        }
        return res;
        // [4,-1,2,-5,-8,0,8]
    }

    void quickSort(int[][] sort, final int k, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(sort, start, end);
        if (partition > k) {
            quickSort(sort, k, start, partition - 1);
        } else {
            quickSort(sort, k, start, partition - 1);
            quickSort(sort, k, partition + 1, end);
        }
    }

    int partition(int[][] sort, int start, int end) {
        int pilot = start;
        int j = pilot + 1;
        for (int i = j; i <= end; i++) {
            if (sort[i][1] >= sort[pilot][1]) {
                swap(sort, i, j);
                j++;
            }
        }
        j--;
        if (j != pilot) {
            swap(sort, j, pilot);
        }
        return j;
    }

    void swap(int[][] sort, int i, int j) {
        int[] aux = sort[i];
        sort[i] = sort[j];
        sort[j] = aux;
    }

    // 基于堆-------------------
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 1) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            heap.offer(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

}
