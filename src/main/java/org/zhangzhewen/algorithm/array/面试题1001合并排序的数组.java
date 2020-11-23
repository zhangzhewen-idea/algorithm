package org.zhangzhewen.algorithm.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 面试题1001合并排序的数组 {
    public static void main(String[] args) {
        new 面试题1001合并排序的数组().merge(new int[]{1, 2, 3, 0, 0, 0},
                3,
                new int[]{2, 5, 6},
                3
        );
//        new 数组的度697().findShortestSubArray(new int[]{1 });
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int ap = m - 1, bp = n - 1, i = A.length - 1, cur;
        while (i >= 0) {
            if (ap == -1) {
                cur = B[bp--];
            } else if (bp == -1) {
                break;
            } else if (A[ap] > B[bp]) {
                cur = A[ap--];
            } else {
                cur = B[bp--];
            }
            A[i--] = cur;
        }
    }
}
