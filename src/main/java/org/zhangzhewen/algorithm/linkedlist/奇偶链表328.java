package org.zhangzhewen.algorithm.linkedlist;

public class 奇偶链表328 {

    public static void main(String[] args) {
        ListNode a1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6, null)
                                                )
                                        )
                                )
                        )
                );

        new 奇偶链表328().oddEvenList(a1);
    }

    public ListNode oddEvenList(ListNode head) {
        int index = 1;
        ListNode odd = head, answer = head, prev = null;
        while (head != null) {
            ListNode auxPrev = head;
            ListNode auxHead = head.next;
            if (index++ % 2 == 1) {
                if (odd != head) {
                    addNode(odd, removeNode(prev, head));
                    odd = odd.next;
                }
            }
            prev = auxPrev;
            head = auxHead;
        }
        return answer;
    }

    ListNode removeNode(ListNode prev, ListNode head) {
        prev.next = head.next;
        return head;
    }

    void addNode(ListNode a, ListNode b) {
        ListNode next = a.next;
        a.next = b;
        b.next = next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
