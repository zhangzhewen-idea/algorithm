package org.zhangzhewen.algorithm.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MergeIntervals
 *
 * @author zhangzhewen
 * @date 2020/6/30
 */
public class MergeIntervals {

    // 时间复杂度 O(nlog(n)) - 对数组的排序
    // 空间复杂度 O(n) - 用了一个额外的result保存结果
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int[] prev = null;
        List<int[]> res = new ArrayList<>();
        for (int[] current : intervals) {
            if (prev == null || current[0] > prev[1]) {
                res.add(prev = current);
            } else {
                prev[1] = Math.max(prev[1], current[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
