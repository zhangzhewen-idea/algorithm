package org.zhangzhewen.algorithm.heap;

import java.util.PriorityQueue;

/**
 * 剑指Offer41数据流中的中位数
 *
 * @author zhangzhewen
 * @date 2020/10/28
 */
public class 剑指Offer41数据流中的中位数 {

    public static void main(String[] args) {
        剑指Offer41数据流中的中位数.MedianFinder o = new MedianFinder();
        o.addNum(1);
        o.addNum(2);
        System.out.println(o.findMedian());
        o.addNum(3);
        System.out.println(o.findMedian());
    }

    static class MedianFinder {
        PriorityQueue<Integer> minHeap, maxHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minHeap.size() != maxHeap.size()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return (minHeap.peek() + maxHeap.peek()) / (2 * 1.0);
            }
        }
    }
}
