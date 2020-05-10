package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * MaxProductSubarray
 * https://time.geekbang.org/course/detail/130-69781
 *
 * @author zhangzhewen
 * @date 2020/4/11
 */
public class MaxProductSubarray {
    public static void main(String[] args) {
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{0, -1, 4, -4, 5, -2, -1, -1, -2, -3, 0, -3, 0, 1}));
    }

    public int maxProduct(int[] nums) {
//        recursion(nums, 0, null, false);

        // 动态规划（动态递推）
        // 1.定义状态：dp[nums的两步][最大和最小值]
        int[][] dp = new int[][]{{nums[0], nums[0]}, {nums[0], nums[0]}};
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 2.定义状态转移方程
            int x = i % 2, y = (i - 1) % 2;
            dp[x][0] = Math.max(Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            dp[x][1] = Math.min(Math.min(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            res = Math.max(dp[x][0], res);
        }
        return res;
    }


    // 递归写法，但是时间复杂度太高，O(2^n)
    int max = Integer.MIN_VALUE;

    private void recursion(int[] nums, int i, Integer product, boolean continues) {
        if (i >= nums.length) {
            return;
        }

        if (!continues) {
            product = null;
        }

        if (product != null) {
            product = nums[i] * product;
        } else {
            product = nums[i];
        }

        if (max < product) {
            max = product;
        }

        recursion(nums, i + 1, product, true);
        recursion(nums, i + 1, product, false);
    }

}
