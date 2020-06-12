package org.zhangzhewen.algorithm.sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TopologySort
 *
 * @author zhangzhewen
 * @date 2020/6/12
 */
public class TopologySort extends Sortable{

    private int[] indegree = new int[]{0,0,1,1,2};

    @Override
    int[] sort(int[] a) {
// todo



        return a;
    }

    public static void main(String[] args) {
        new TopologySort().print();
    }

}
