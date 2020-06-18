package org.zhangzhewen.algorithm;

/**
 * ArrayCircle
 *
 * @author zhangzhewen
 * @date 2020/6/18
 */
public class ArrayCircle {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {10,1, 1, 5},
                {9, 8, 7, 6}};
        int len = a.length * 2 + a[0].length * 2 - 4;
        for (int i = 0; i < len; i++) {
            if (i < a[0].length) {
                System.out.println(a[0][i]);
            } else if (i < (a[0].length + a.length - 1)) {
                System.out.println(a[i - a[0].length + 1][a[0].length - 1]);
            } else if (i < (a[0].length * 2 + a.length - 2)) {
                System.out.println(a[a.length - 1][(a[0].length * 2 + a.length - 2) - i - 1]);
            } else {
                System.out.println(a[(len) - i][0]);
            }
        }
    }
}
