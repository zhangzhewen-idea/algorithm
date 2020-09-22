package org.zhangzhewen.algorithm.linkedlist;

import java.util.*;

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
public class 面试题0201移除重复节点 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(2);
        ListNode a6 = new ListNode(1);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        new 面试题0201移除重复节点().removeDuplicateNodes(
                a1
        );

        LinkedList<Integer> res = new LinkedList();

        System.out.println(a1);
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> occurred = new HashSet();
        ListNode pos = head;
        while(pos.next!=null){
            if(occurred.add(pos.next.val)){
                pos = pos.next;
            }else{
                pos.next = pos.next.next;
            }
        }
        pos.next = null;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
