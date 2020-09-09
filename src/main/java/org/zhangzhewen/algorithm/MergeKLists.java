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

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;

        ListNode a4 = new ListNode(1);
        ListNode a5 = new ListNode(3);
        ListNode a6 = new ListNode(4);
        a4.next = a5;
        a5.next = a6;

        ListNode a7 = new ListNode(2);
        ListNode a8 = new ListNode(6);
        a7.next = a8;

        ListNode[] a = new ListNode[]{a1, a4, a7};


//        [[1,2,3],[4,5,6,7]]

        ListNode a11 = new ListNode(1);
        ListNode a21 = new ListNode(2);
        ListNode a31 = new ListNode(3);
        a11.next = a21;
        a21.next = a31;

        ListNode a41 = new ListNode(4);
        ListNode a51 = new ListNode(5);
        ListNode a61 = new ListNode(6);
        ListNode a71 = new ListNode(7);
        a41.next = a51;
        a51.next = a61;
        a61.next = a71;

        ListNode[] aa1 = new ListNode[]{a11, a41};

    }

    // 利用最小堆 O(nk * log(k))
    public ListNode mergeKLists2(ListNode[] lists) {
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

    // 利用归并 O(nk * log(k)) 不像最小堆解法一样需要维护一个额外的数据结构，空间复杂度是O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);

    }

    /**
     * 主函数类似之前的归并排序
     * 从中间切一刀
     * 然后递归地处理左边和右边的列表，最后合并起来
     *
     * @param lists
     * @param low
     * @param high
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }

        int middle = low + (high - low) / 2;
        return mergeTwoLists(
                mergeKLists(lists, low, middle),
                mergeKLists(lists, middle + 1, high)
        );
    }

    // resursion方式
//    public ListNode mergeTwoLists(ListNode a, ListNode b) {
//        if (a == null) {
//            return b;
//        }
//        if (b == null) {
//            return a;
//        }
//
//        if (a.val <= b.val) {
//            a.next = mergeTwoLists(a.next, b);
//            return a;
//        }
//
//        b.next = mergeTwoLists(a, b.next);
//        return b;
//    }

    // while方式
    ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }

        ListNode head = new ListNode(0), p = head;
        while (true) {
            if (a == null) {
                p.next = b;
                break;
            }
            if (b == null) {
                p.next = a;
                break;
            }
            if (a.val < b.val) {
                p.next = a;
                p = p.next;
                a = a.next;
            } else {
                p.next = b;
                p = p.next;
                b = b.next;
            }
        }

        return head.next;
    }

    static class ListNode {
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
