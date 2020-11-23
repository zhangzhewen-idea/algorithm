package org.zhangzhewen.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 三个数的最大乘积628 {
    public static void main(String[] args) {

    }

    public int maximumProduct(int[] nums) {
        int len = nums.length;
        if (len <= 6) {
            return helper(nums);
        }
        Arrays.sort(nums);
        int tail = len - 1;
        return helper(new int[]{nums[0], nums[1], nums[2], nums[tail], nums[tail - 1], nums[tail - 2]});
    }

    private int helper(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    max = Math.max(nums[i] * nums[j] * nums[k], max);
                }
            }
        }
        return max;
    }

}
