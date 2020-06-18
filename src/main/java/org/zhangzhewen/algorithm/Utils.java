package org.zhangzhewen.algorithm;

/**
 * Utils
 *
 * @author zhangzhewen
 * @date 2020/6/18
 */
public class Utils {

    public static int min(int... a) {
        int min = a[0];
        for (int i : a) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

}
