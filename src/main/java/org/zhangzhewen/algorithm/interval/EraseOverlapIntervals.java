package org.zhangzhewen.algorithm.interval;

import java.util.Arrays;

/**
 * EraseOverlapIntervals
 *
 * @author zhangzhewen
 * @date 2020/9/9
 */
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        System.out.println(new EraseOverlapIntervals().eraseOverlapIntervals(new int[][]{{1,3},{3,6},{6,9},{1,9},{1,9},{1,2}}));
    }


    // 解法二：贪婪法
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }

        // 将所有的区间按照起始时间的先后顺序排序
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));

        // 定义一个end变量记录当前的最小结束时间点，
        // 定义一个count变量记录到目前为止删除了多少区间
        int end = intervals[0][1],count=0;

        // 从第二个区间开始，判断一下当前区间和前一个区间的结束时间
        for (int i = 1; i < intervals.length; i++) {
            // 如果发现当前区间与前一个区间有重叠，即当前区间的起始时间小于上一个区间的结束时间，
            // 则end变量记录下两个结束时间的最小值，意味着把结束时间晚的区间删除，计数加一
            if(intervals[i][0]<end){
                end = Math.min(end,intervals[i][1]);
                count++;
            } else{
                // 如果没有发现重叠，根据贪婪发，更新end变量为当前区间的结束时间
                end = intervals[i][1];
            }
        }

        return count;
    }


/*
    // 解法一：暴力法
    public int eraseOverlapIntervals(int[][] intervals) {
        // 主体函数中，先将区间按照起始时间的先后顺序排序，然后调用递归函数
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        return eraseOverlapIntervals(-1, 0, intervals);
    }


    int eraseOverlapIntervals(int prev, int curr, int[][] intervals) {
        // 递归函数中，先检查所有区间是否已处理完，是的话，表明不需要删除操作，直接返回
        if (curr == intervals.length) {
            return 0;
        }

        // 定义taken与nottaken变量，用来记录：
        // 如果保留当前区间的话，最少需要删除多少其他区间
        // 如果删除当前区间的话，最少需要删除多少区间
        int taken = Integer.MAX_VALUE, nottaken;

        if (prev == -1 || intervals[prev][1] <= intervals[curr][0]) {
            // 只有当prev,curr没有发生重叠的时候，才可以选择保留当前的区间curr
            taken = eraseOverlapIntervals(curr, curr + 1, intervals);
        }

        // 其他情况，可以考虑删除掉curr区间，看看删除了它之后会不会产生最好的结果
        nottaken = eraseOverlapIntervals(prev, curr + 1, intervals) + 1;

        // 最后返回两种情况下的最小值，判断是否删除当前区间
        return Math.min(taken, nottaken);
    }*/

}
