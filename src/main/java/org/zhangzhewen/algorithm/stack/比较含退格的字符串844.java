package org.zhangzhewen.algorithm.stack;

import java.util.Stack;

/**
 * 比较含退格的字符串844
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 比较含退格的字符串844 {
    public static void main(String[] args) {
        new 比较含退格的字符串844().backspaceCompare("y#fo##f", "y#f#o##f");
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!t.isEmpty()) {
                    t.pop();
                }
            } else {
                t.push(c);
            }
        }
        while (!s.isEmpty() && !t.isEmpty() && s.peek().equals(t.peek())) {
            s.pop();
            t.pop();
        }
        return s.isEmpty() && t.isEmpty();
    }
}
