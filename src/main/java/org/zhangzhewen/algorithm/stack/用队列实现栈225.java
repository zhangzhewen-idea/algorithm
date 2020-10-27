package org.zhangzhewen.algorithm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 用队列实现栈225
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 用队列实现栈225 {
    public static void main(String[] args) {

    }
    class MyStack {

        List<Integer> list = new ArrayList<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            list.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int res = list.get(list.size()-1);
            list.remove(list.size()-1);
            return res;
        }

        /** Get the top element. */
        public int top() {
            return list.get(list.size()-1);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return list.isEmpty();
        }
    }
}
