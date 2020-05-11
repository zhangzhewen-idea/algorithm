package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * 类似 最大上升子序列 等问题。
 * Subsequence
 *
 * @author zhangzhewen
 * @date 2020/5/11
 */
public class Subsequence {
    public static void main(String[] args) {
//        System.out.println(new Subsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(new Subsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 1.定义状态
        int[] dp = new int[nums.length];

        // 2.定义状态转移方程
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            // 找到 最靠近nums[i] 的数的子序列个数
            int approachNumIndex = i;
            int approachNum = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j] && approachNum <= dp[j]){
                    approachNum = dp[j];
                    approachNumIndex = j;
                }
            }
            if (approachNumIndex != i) {
                dp[i] = dp[approachNumIndex] + 1;
                if (maxCount < dp[i]) {
                    maxCount = dp[i];
                }
            }
        }

        return maxCount + 1;
    }
}
