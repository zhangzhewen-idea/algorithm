package org.zhangzhewen.algorithm.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题0804幂集
 * <p>
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author zhangzhewen
 * @date 2020/11/2
 */
public class 面试题0804幂集 {

    public static void main(String[] args) {
        new 面试题0804幂集().subsets(new int[]{1, 2, 3});
    }

    //迭代写法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        answers.add(new ArrayList<>());
        //当前元素
        for (int n : nums) {
            //原来元素的基础数
            int length = answers.size();
            for (int i = 0; i < length; i++) {
                List<Integer> lists = new ArrayList<>();
                //将原来的元素集合全部加入新集合中
                lists.addAll(answers.get(i));
                //将当前元素加入到新集合中
                lists.add(n);
                //结果集
                answers.add(lists);
            }

        }
        return answers;
    }
/*
// 递归写法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int pos, List<Integer> sub, List<List<Integer>> res) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[pos]);
        helper(nums, pos + 1, sub, res);
        sub.remove(sub.size() - 1);
        helper(nums, pos + 1, sub, res);
    }
*/
}
