package org.zhangzhewen.algorithm.binary_search;

public class 寻找峰值162 {

    public static void main(String[] args) {
        new 寻找峰值162().findPeakElement(new int[]{1});
    }

    public int findPeakElement(int[] nums) {
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
