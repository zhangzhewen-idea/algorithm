package org.zhangzhewen.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/2/5
 */
public class LeetCode {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap();
            for(int i = 0 ; i < nums.length;i ++){
                map.put(nums[i],i);
            }
            for(int i = 0 ; i < nums.length ; i ++){
                Integer index = map.get(target - nums[i]);
                if(index !=null){
                    return new int[]{i,index};
                }
            }
            return null;
        }

    public static void main(String[] args) {
        twoSum(new int[]{3,2,4},6);
    }
}
