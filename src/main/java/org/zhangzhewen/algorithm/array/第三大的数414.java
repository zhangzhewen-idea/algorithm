package org.zhangzhewen.algorithm.array;

public class 第三大的数414 {

    public static void main(String[] args) {
        new 第三大的数414().thirdMax(new int[]{2, 2, 3, 1});
//        new 第三大的数414().thirdMax(new int[]{1, 2, 2, 5, 3, 5});
    }

    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        /*for (int i = 1; i < 3; i++) {
            int j = i, aux = nums[i];
            while (j > 0 && aux > nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                nums[j] = aux;
            }
        }*/

        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == first || nums[i] == second || nums[i] == third) {
                continue;
            }
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
