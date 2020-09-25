package org.zhangzhewen.algorithm.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]

 *
 *
 * @author zhangzhewen
 * @date 2020/9/24
 */
public class 子集78 {

    public static void main(String[] args) {
        new 子集78().subsets(new int[]{1,2,3});
    }

    List<List<Integer>> res = new ArrayList();
    List<Integer> t = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }
    void dfs(int cur,final int[] nums){
        if(cur==nums.length){
            res.add(new ArrayList(t));
            return ;
        }
        // 取
        t.add(nums[cur]);
        dfs(cur+1,nums);
        // 不取
        t.remove(t.size()-1);
        dfs(cur+1,nums);
    }




}
