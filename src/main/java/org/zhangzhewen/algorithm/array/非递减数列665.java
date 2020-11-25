package org.zhangzhewen.algorithm.array;

public class 非递减数列665 {
    public static void main(String[] args) {
        System.out.println(new 非递减数列665().checkPossibility(new int[]{5, 1, 8, 9}));
    }

    public boolean checkPossibility(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                sum++;
                if (sum >= 2) {
                    return false;
                }
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return true;
    }
}
