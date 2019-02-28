package org.zhangzhewen.algorithm;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

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

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null){
            return null;
        }
        Deque<Integer> window = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i ++){
            //移除窗口外元素
            if(i>=k&&window.getFirst()<=i-k){
                window.removeFirst();
            }
            while(window.size()>0 && nums[window.getLast()]<=nums[i]){
                window.removeLast();
            }
            window.add(i);
            if(i >= k - 1){
                result.add(nums[window.getFirst()]);
            }
        }
        int [] res = new int[result.size()];
        for(int i = 0 ;i < result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        twoSum(new int[]{3,2,4},6);

        /*
        int[] result = maxSlidingWindow(new int[]{1,10,2,-1,3},2);
        //期望的是 10 10 2 3
        for(int i = 0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        */

    }

}
