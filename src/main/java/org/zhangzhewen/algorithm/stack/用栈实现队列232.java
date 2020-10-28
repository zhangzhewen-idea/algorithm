package org.zhangzhewen.algorithm.stack;

import java.util.Stack;

/**
 * 用栈实现队列232
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 用栈实现队列232 {

    public static void main(String[] args) {

    }

    class MyQueue {

        Stack<Integer> s1, s2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            s1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (peek() == -1) {
                return -1;
            }
            return s2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (s2.isEmpty()) {
                if (s1.isEmpty()) {
                    return -1;
                }
                while (!s1.isEmpty()) {
                    for (int e : s1) {
                        s2.push(e);
                    }
                }
            }
            return s2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
