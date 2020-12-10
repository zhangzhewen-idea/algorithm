package org.zhangzhewen.algorithm.binary_search;

public class 剑指Offer11旋转数组的最小数字 {
    public static void main(String[] args) {
        new 剑指Offer11旋转数组的最小数字().search(new int[]{1, 3}, 3);
    }

    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        if(nums[l]>nums[h]){
            while (l < h) {
                int pivot = l + (h - l) / 2;
                if (nums[pivot] > nums[h]) {
                    l = pivot+1;
                } else {
                    h = pivot;
                }
            }
            return l;
        }
        while(l<=h){
            int pivot = l + (h-l)/2;
            if(nums[pivot]==target){
                return pivot;
            }else if(nums[pivot]>target){
                h = pivot-1;
            }else{
                l = pivot+1;
            }
        }
        return -1;
    }

}
