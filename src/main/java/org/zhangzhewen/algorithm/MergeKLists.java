package org.zhangzhewen.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * MergeKLists
 * 有三种解决方案：1.暴力 2.利用最小堆 3.利用归并
 *
 * @author zhangzhewen
 * @date 2020/6/30
 */
public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 利用一个空的链表头方便我们插入节点
        ListNode fakeHead = new ListNode(0), p = fakeHead;
        int k = lists.length;
        // 定义一个最小堆来保存k个链表节点
        // 将k个链表的头放到最小堆中
        PriorityQueue<ListNode> heap = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 从最小堆中将当前最小节点取出，插入到结果链表中
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }
        }

        // 如果发现该节点后还有后续节点，将其节点加入最小堆中
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();

            p.next = node;
            p = p.next;

            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        // 最后返回结果链表
        return fakeHead.next;
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

}
