package org.zhangzhewen.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * FindK
 *
 * @author zhangzhewen
 * @date 2020/6/19
 */
public class Getk {
    /*
    寻找 k 值：
    k 值为无序数组中的一项：所有左值都比它更小，所有右值都比它更大
    [1, 3, 2, 5, 7, 7, 9]
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 5, 7, 7, 9};
        for (Integer s : getk(arr)) {
            System.out.print(s + " ");
        }
    }

    public static List<Integer> getk(int[] num) {
        List<Integer> res = new ArrayList<Integer>();

        if (num.length < 3) {
            return res;
        }

        int numLen = num.length;
        int[] leftToRight = new int[num.length];
        int[] rightToLeft = new int[num.length];
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;

        for (int i = 1; i < num.length - 1; i++) {
            leftToRight[i] = Math.max(maxLeft, num[i - 1]);
            maxLeft = leftToRight[i];
            rightToLeft[numLen - 1 - i] = Math.min(minRight, num[numLen - i]);
            minRight = rightToLeft[numLen - 1 - i];
        }

        for (int i = 1; i < numLen - 1; i++) {
            if (num[i] > leftToRight[i] && num[i] < rightToLeft[i]) {
                res.add(num[i]);
            }
        }

        return res;
    }


}
