package org.zhangzhewen.algorithm.sort;

public class InsertSort extends Sortable {


    public int[] sort2(int[] a) {
        int length = a.length;
        for (int i = 1,j,tmp; i < length; i++) {
            tmp = a[i];
            j = i;
            while (j > 0 && tmp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            if (j != i) {
                a[j] = tmp;
            }
        }
        return a;
    }


    public int[] sort(int[] a) {

        return sort2(a);


    }


    public static void main(String[] args) {
        new InsertSort().print();
    }


}
