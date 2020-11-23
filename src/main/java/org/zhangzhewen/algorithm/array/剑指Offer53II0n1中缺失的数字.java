package org.zhangzhewen.algorithm.array;

public class 剑指Offer53II0n1中缺失的数字 {
    public static void main(String[] args) {
        new 剑指Offer53II0n1中缺失的数字().missingNumber(new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9});
    }

    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid == nums[mid]) {
                l = mid + 1;
                ans = l;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
}
