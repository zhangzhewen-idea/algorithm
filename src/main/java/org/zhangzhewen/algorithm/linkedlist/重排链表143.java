package org.zhangzhewen.algorithm.linkedlist;

/**
 * 重排链表143
 * todo 有问题需要继续做
 *
 * @author zhangzhewen
 * @date 2020/10/20
 */
public class 重排链表143 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        new 重排链表143().reorderList(head);
    }

    public void reorderList(ListNode head) {
        ListNode slow = head,fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev = null;
        ListNode aux = null;
        ListNode aux2 = null;
        while(slow!=null){
            aux = slow.next;
            if(prev!=null){
                slow.next = prev;
            }else{
                slow.next = null;
            }
            prev = slow;
            slow = aux;
        }
        while(head!=null){
            aux = head.next;
            head.next = prev;
            head = aux;
            aux2 = prev.next;
            prev.next = head;
            prev = aux2;
        }
        System.out.println();
    }

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
