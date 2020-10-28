package org.zhangzhewen.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素215
 *
 * @author zhangzhewen
 * @date 2020/10/28
 */
public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {
        new 数组中的第K个最大元素215().findKthLargest(new int[]{3,2,1,5,6,4},2);
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a,b)->b-a);
        for(int i : nums){
            heap.offer(i);
        }
        int res = 0;
        while(k-->0){
            res = heap.poll();
        }
        return res;
    }
}
