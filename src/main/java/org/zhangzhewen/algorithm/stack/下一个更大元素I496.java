package org.zhangzhewen.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素I496
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 下一个更大元素I496 {
    public static void main(String[] args) {
        new 下一个更大元素I496().nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty()&&stack.peek() < nums[i]) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.get(findNums[i]);
        }
        return findNums;
    }

    // 标准答案
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek()) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

}
