package org.zhangzhewen.algorithm.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 面试题0302栈的最小值
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 面试题0302栈的最小值 {

    class MinStack {
        LinkedList<Integer> list;
        Stack<Integer> minStack = new Stack();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            if(!minStack.isEmpty()){
                if(minStack.peek()<x){
                    minStack.push(minStack.peek());
                }else{
                    minStack.push(x);
                }
            }else{
                minStack.push(x);
            }
            list.add(x);
        }

        public void pop() {
            minStack.pop();
            list.removeLast();
        }

        public int top() {
            return list.getLast();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
