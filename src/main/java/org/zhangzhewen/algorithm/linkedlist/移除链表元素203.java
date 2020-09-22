package org.zhangzhewen.algorithm.linkedlist;

/**
 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5

 *
 * @author zhangzhewen
 * @date 2020/9/21
 */
public class 移除链表元素203 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        new 移除链表元素203().removeElements(
                a1,6
        );


        System.out.println(a1);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(-1),cur = ans;
        cur.next = head;
        while(cur!=null){
            if(cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return ans.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
