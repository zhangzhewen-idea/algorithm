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
        System.out.println(new Subsequence().lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 时间复杂度 N*logN
        // resArr[0] 是个数
        int[] resArr = new int[nums.length + 1];
        resArr[1] = nums[0];
        resArr[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            // 当前数大于数组所有元素，追加
            if (resArr[resArr[0]] < nums[i]) {
                resArr[0]++;
                resArr[resArr[0]] = nums[i];
            }
            // 进行二分查找，找到【上界】的位置，替换，结果就是resArr[0]
            else {
                int high = resArr[0];
                int low = 1;
                int mid = 1;
                while (low <= high) {
                    mid = low + (high - low) / 2;
                    if (resArr[mid] > nums[i]) {
                        high = mid - 1;
                    } else if (resArr[mid] < nums[i]) {
                        low = mid + 1;
                        mid++;
                    } else {
                        break;
                    }
                }
                resArr[mid] = nums[i];
            }
        }

        return resArr[0];
    }

    // 标准的
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        // 时间复杂度 N^2
//        // 1.定义状态
//        int[] dp = new int[nums.length];
//
//        // 2.定义状态转移方程
//        int res = 0;
//        for (int i = 1; i < nums.length; i++) {
//            // 找到 小于nums[i] 并且 子序列个数最大的 下标
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//
//        return res+1;
//    }

    // 自己写的
    //    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//          // 时间复杂度 N^2
//        // 1.定义状态
//        int[] dp = new int[nums.length];
//
//        // 2.定义状态转移方程
//        int maxCount = 0;
//        for (int i = 0; i < nums.length; i++) {
//            // 找到 小于nums[i] 并且 子序列个数最大的 下标
//            int maxIndex = i;
//            int maxNum = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                if(nums[i] > nums[j] && maxNum <= dp[j]){
//                    maxNum = dp[j];
//                    maxIndex = j;
//                }
//            }
//            if (maxIndex != i) {
//                dp[i] = dp[maxIndex] + 1;
//                if (maxCount < dp[i]) {
//                    maxCount = dp[i];
//                }
//            }
//        }
//
//        return maxCount + 1;
//    }
}
