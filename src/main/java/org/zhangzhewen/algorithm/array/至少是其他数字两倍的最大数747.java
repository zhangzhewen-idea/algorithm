package org.zhangzhewen.algorithm.array;

public class 至少是其他数字两倍的最大数747 {
    public static void main(String[] args) {
        new 至少是其他数字两倍的最大数747().dominantIndex(new int[]{1, 0});
    }

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxIds = 0, max = nums[0], secondMax = nums[1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIds = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (!(max >= secondMax * 2)) {
            maxIds = -1;
        }
        return maxIds;
    }
}
