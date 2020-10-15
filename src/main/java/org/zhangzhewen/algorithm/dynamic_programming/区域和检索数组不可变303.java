package org.zhangzhewen.algorithm.dynamic_programming;


import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * f
 *
 * @author zhangzhewen
 * @date 2020/10/13
 */
public class 区域和检索数组不可变303 {

    private int[] sum;

    public 区域和检索数组不可变303(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
