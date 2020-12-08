package org.zhangzhewen.algorithm.two_pointers;

import java.util.Arrays;

public class 合并两个有序数组88 {

    public static void main(String[] args) {
        new 合并两个有序数组88().merge(new int[]{1, 2, 3, 0, 0, 0},
                3,
                new int[]{2, 5, 6},
                3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] auxNum1 = Arrays.copyOf(nums1, m);
        int auxNum1Pointer = 0, nums2Pointer = 0, nums1Pointer = 0;
        if (nums1Pointer < nums1.length && auxNum1Pointer < auxNum1.length && nums2Pointer < nums2.length) {
            if (auxNum1[auxNum1Pointer] < nums2[nums2Pointer]) {
                nums1[nums1Pointer++] = auxNum1[auxNum1Pointer++];
            } else {
                nums1[nums1Pointer++] = nums2[nums2Pointer++];
            }
        }
        while (auxNum1Pointer < auxNum1.length) {
            nums1[nums1Pointer++] = auxNum1[auxNum1Pointer++];
        }
        while (nums2Pointer < nums2.length) {
            nums1[nums1Pointer++] = nums2[nums2Pointer++];
        }
    }

}
