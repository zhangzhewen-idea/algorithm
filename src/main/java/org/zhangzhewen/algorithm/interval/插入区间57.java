package org.zhangzhewen.algorithm.interval;

import java.util.LinkedList;
import java.util.List;

/**
 * 插入区间57
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * @author zhangzhewen
 * @date 2020/11/4
 */
public class 插入区间57 {

    public static void main(String[] args) {
        new 插入区间57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList();
        int i = 0;
        boolean hasInserted = false;
        for (; i < intervals.length; i++) {
            if (!hasInserted && intervals[i][0] > newInterval[0] && intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                hasInserted = true;
            }
            if (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            } else {
                res.add(intervals[i]);
            }
        }
        if(!hasInserted){
            res.add(intervals[i]);
        }
        int[][] arr = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            arr[j] = res.get(j);
        }
        return arr;
    }
}
