package org.zhangzhewen.algorithm.linkedlist;

/**
 * ReverseLinkedList
 *
 * @author zhangzhewen
 * @date 2020/6/24
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    // while
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode tmpNext = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = tmpNext;
//        }
//
//        return pre;
//    }


    // 递归
    public ListNode reverseList(ListNode head) {
        // 如果当前要反转的节点为 null 或者反转链表为 null
        // head.next 为 null，即反转链表的尾结点不存在，即反转链表不存在
        if (head == null || head.next == null) return head;
        // 节点 p 其实就是反转链表的头节点
        ListNode p = reverseList(head.next);
        // 我们将反转链表的尾结点（head.next）的 next 指向当前即将反转的节点
        head.next.next = head;
        // 然后让当前节点变成反转链表的尾结点
        head.next = null;
        // 返回反转链表的头结点
        return p;
    }
}
