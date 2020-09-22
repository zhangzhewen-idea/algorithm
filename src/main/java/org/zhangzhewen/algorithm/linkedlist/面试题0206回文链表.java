package org.zhangzhewen.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 编写一个函数，检查输入的链表是否是回文的。

  

 示例 1：

 输入： 1->2
 输出： false
 示例 2：

 输入： 1->2->2->1
 输出： true
  

 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 *
 * @author zhangzhewen
 * @date 2020/9/21
 */
public class 面试题0206回文链表 {

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

        new 面试题0206回文链表().isPalindrome(
                a1
        );


        System.out.println(a1);
    }

    public boolean isPalindrome(ListNode head) {
        // 寻找中点
        ListNode midNode = findMidNode(head);
        // 翻转链表
        ListNode halfHeadNode = reverseLinked(midNode.next);

        while(midNode!=null&&halfHeadNode!=null){
            if(midNode.val!=halfHeadNode.val){
                return false;
            }
            midNode = midNode.next;
            halfHeadNode = halfHeadNode.next;
        }
        return true;
    }

    private ListNode reverseLinked(ListNode head) {
        ListNode pre = null;
        while(head!=null){
            ListNode aux4Next = head.next;
            head.next = pre;
            pre = head;
            head = aux4Next;
        }
        return pre;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head ,fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
