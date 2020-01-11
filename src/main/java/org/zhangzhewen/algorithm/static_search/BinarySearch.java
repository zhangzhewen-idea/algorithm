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

        return -1;
    }























    public static void main(String[] args) {
        new BinarySearch().run();
    }
}
