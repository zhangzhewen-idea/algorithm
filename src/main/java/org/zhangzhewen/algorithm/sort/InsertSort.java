package org.zhangzhewen.algorithm.sort;

public class InsertSort {

    public static int[] insertionSort(int[] a) {
        int n = a.length;
        int w;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i-1;
            for(;j>=0&&a[j]>value;--j){
                a[j+1] = a[j];
            }
            a[j+1]=value;
        }
        return a;
    }

    // 插入排序，a 表示数组，n 表示数组大小
    public void insertionSort2(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {
        int[] a = insertionSort(new int[]{10, 8, 7, 5, 3});
        for (int e : a) {
            System.out.print(e + " ");
        }
    }


}
