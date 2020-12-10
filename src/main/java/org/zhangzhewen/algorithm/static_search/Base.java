package org.zhangzhewen.algorithm.static_search;

/**
 * 总结： 平均性能平均性能：斐波那契>折半>插值
 *
 * 因为折半查找进行加法与除法运算（mid = low + (high - low) / 2）,插值查找进行复杂的四则运算( mid = low + (key - a[low] / (a[high] - a[low]) * (high - low)) )，
 * 而斐波那契查找只是运用简单加减法运算 (mid = low + f[k-1] -1) ，在海量的数据查找过程中，这种席位的差别会影响最终的查找效率。
 * 三种有序表的查找本质上是分割点的选择不同，各有优劣，实际开发可根据数据的特点综合考虑再做决定。
 *
 * 二分原理写的很好的：https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/
 * 官方二分攻略：https://leetcode-cn.com/leetbook/read/binary-search/xerqxt/
 *
 * http://blog.jobbole.com/73517/
 * @author zhangzhewen
 * @date 2019/5/28
 */
public abstract class Base {
    abstract protected int search(int[] a,int n);

    protected void run(){
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        int n = 3;

        System.out.println("{1,2,3,4,5,6,7,8,9},target:"+n+",result:"+ search(a,n));
    }
}

/*

【二分查找两种模板 left<=right和left<right】：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/solution/er-fen-cha-zhao-liang-chong-mo-ban-leftrighthe-lef/
模板1：while(left<=right)
循环体内有3个分支
在循环体中返回目标索引
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(nums[mid]>nums[mid+1]){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        // 这里return什么都可以，因为对于此题来说，在循环体内一定会返回
        return -1;
    }
}
模板2：while(left<right)
循环体内有2个分支
在循环体外返回目标索引，在循环体内缩减搜索区间
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            // 缩减区间为[mid+1,right]
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }
            // 缩减区间为[left,mid]
            else {
                right=mid;
            }
        }
        // left=right时退出循环，返回left或right是一样的
        return left;
    }
}

 */
