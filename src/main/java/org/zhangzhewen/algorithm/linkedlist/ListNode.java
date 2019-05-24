package org.zhangzhewen.algorithm.linkedlist;

import lombok.Data;
import lombok.ToString;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/24
 */
@Data
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      @Override
      public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
      }
}
