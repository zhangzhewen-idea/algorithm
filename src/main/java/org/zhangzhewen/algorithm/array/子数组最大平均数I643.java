package org.zhangzhewen.algorithm.array;

public class 子数组最大平均数I643 {
    public static void main(String[] args) {
        new 子数组最大平均数I643().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3},
                4);
    }

    public double findMaxAverage(int[] nums, int k) {
        int l = 0, h = 0, sum = 0, maxSum = Integer.MIN_VALUE;
        while (h < nums.length) {
            sum += nums[h];
            if (h - l >= k) {
                sum -= nums[l];
                l++;
            }
            if (h >= k - 1) {
                maxSum = Math.max(maxSum, sum);
            }
            h++;
        }
        return maxSum * 1.0 / k;
    }
}
