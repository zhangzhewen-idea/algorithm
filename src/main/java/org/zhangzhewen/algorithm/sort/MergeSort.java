package org.zhangzhewen.algorithm.sort;

import java.util.Arrays;

public class MergeSort extends Sortable {

    public int[] sort2(int[] a) {

        if (a.length < 2) {
            return a;
        }

        int middle = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, middle);
        int[] right = Arrays.copyOfRange(a, middle, a.length);

        return merge2(sort(left), sort(right));
    }

    private int[] merge2(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0, l = 0, r = 0;
        while (i < result.length) {
            if (l == left.length) {
                result[i++] = right[r++];
            } else if (r == right.length) {
                result[i++] = left[l++];
            } else if (left[l] > right[r]) {
                result[i++] = right[r++];
            } else {
                result[i++] = left[l++];
            }
        }

        return result;
    }

    @Override
    int[] sort(int[] a) {


        return null;
    }


    public static void main(String[] args) {
        new MergeSort().print();
    }
}
