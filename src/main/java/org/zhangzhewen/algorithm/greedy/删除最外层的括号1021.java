package org.zhangzhewen.algorithm.greedy;

import java.util.Stack;

/**
 * 删除最外层的括号1021
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 删除最外层的括号1021 {

    public static void main(String[] args) {
        new 删除最外层的括号1021().removeOuterParentheses("((()))(())");
    }

    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack();
        String res = "";
        for(char c : S.toCharArray()){
            if('('==c){
                if(!stack.isEmpty()){
                    res+=c;
                }
                stack.push(c);
            }else {
                stack.pop();
                if(!stack.isEmpty()){
                    res+=c;
                }
            }
        }
        return res;
    }

}
