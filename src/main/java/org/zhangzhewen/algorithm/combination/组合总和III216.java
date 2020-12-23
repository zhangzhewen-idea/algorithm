package org.zhangzhewen.algorithm.combination;

import java.util.ArrayList;
import java.util.List;


/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class 组合总和III216 {

    public static void main(String[] args) {
        new 组合总和III216().combinationSum3(3,7);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 1; i <= 9; i++) {
            nums[i - 1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, k, n, new ArrayList());
        return res;
    }

    void dfs(List<List<Integer>> res, int[] nums, int ids, int k, int n, List<Integer> sequence) {
        System.out.println();
        for (int i : sequence) {
            System.out.print(i+" ");
        }
        if (sequence.size() == k && n == 0) {
            res.add(new ArrayList(sequence));
            return;
        } else if (ids == nums.length || n < 0) {
            return;
        }
        dfs(res,nums,ids+1,k,n,sequence);
        if (sequence.size() < k) {
            sequence.add(nums[ids]);
            dfs(res,nums,ids+1,k,n-nums[ids],sequence);
            sequence.remove(sequence.size()-1);
        }
    }

}
