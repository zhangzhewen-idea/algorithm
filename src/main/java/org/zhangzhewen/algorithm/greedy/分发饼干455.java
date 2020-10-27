package org.zhangzhewen.algorithm.greedy;

import java.util.Arrays;

/**
 * 分发饼干455
 *
 * @author zhangzhewen
 * @date 2020/10/26
 */
public class 分发饼干455 {
    public static void main(String[] args) {
        new 分发饼干455().findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8});
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0, sPointer = 0;
        for (int i = 0; i < g.length; i++) {
            for (; sPointer < s.length; ) {
                if (g[i] <= s[sPointer++]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
