package org.zhangzhewen.algorithm.static_search;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/28
 */
public class BinarySearch extends Base{


    protected int search2(int[] nums,int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }



    protected int search(int[] nums,int target) {
        int l = 0,h = nums.length;
        while(l<h){
            int mid = l+(h-l)/2;
            if(nums[mid]<target){
                l=mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }























    public static void main(String[] args) {
        new BinarySearch().search(new int[]{1,2,2,2,3},2);
    }
}
