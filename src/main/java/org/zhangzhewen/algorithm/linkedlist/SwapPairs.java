package org.zhangzhewen.algorithm.linkedlist;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/24
 */
public class SwapPairs {

    public static void main(String[] args) {
        //Given 1->2->3->4, you should return the list as 2->1->4->3.
        ListNode n1 =new ListNode(1);
        ListNode n2 =new ListNode(2);
        ListNode n3 =new ListNode(3);
        ListNode n4 =new ListNode(4);
        ListNode n5 =new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(swapPairs2(n1));
    }

    public static ListNode swapPairs2(ListNode head){
        if(head==null|| head.next==null){
            return head;
        }

        ListNode result = head.next;
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            ListNode a = cur.next;
            ListNode b = cur;
            if(prev!=null){
                prev.next = a;
            }
            b.next = a.next;
            a.next = b;
            prev = b;
            cur = b.next;
        }
        return result;
    }












    public static ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next == null) return head;
        ListNode result = head.next;
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            ListNode b = cur.next;
            ListNode l = b.next;
            if(prev!=null){
                prev.next = b;
            }
            b.next = cur;
            cur.next = l;

            prev = cur;
            cur = l;

        }
        return result;
    }

}
