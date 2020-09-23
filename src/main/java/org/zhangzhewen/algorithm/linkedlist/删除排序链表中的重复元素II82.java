package org.zhangzhewen.algorithm.linkedlist;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author zhangzhewen
 * @date 2020/9/21
 */
public class 删除排序链表中的重复元素II82 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        new 删除排序链表中的重复元素II82().deleteDuplicates(
                a1
        );


        System.out.println(a1);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(-1), cur = ans;
        cur.next = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int dup = cur.next.val;
                ListNode auxCur = cur.next.next.next;
                while (auxCur != null && auxCur.val == dup) {
                    auxCur = auxCur.next;
                }
                cur.next = auxCur;
            }
            cur = cur.next;
        }
        return ans.next;
    }

}
