package org.zhangzhewen.algorithm.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * @author zhangzhewen
 * @date 2020/9/21
 */
public class 面试题0203删除中间节点 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(9);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
//        a4.next = a5;
//        a5.next = a6;

        new 面试题0203删除中间节点().deleteNode(
                a1
        );

        LinkedList<Integer> res = new LinkedList();

        System.out.println(a1);
    }

    public void deleteNode(ListNode node) {
        Map<Integer, ListNode> map = new HashMap();
        int count = 0;
        while (node != null) {
            map.put(++count, node);
            node = node.next;
        }
        ListNode pre = map.get(count / 2 - 1);
        ListNode next = map.get(count / 2 + 1);
        pre.next = next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
