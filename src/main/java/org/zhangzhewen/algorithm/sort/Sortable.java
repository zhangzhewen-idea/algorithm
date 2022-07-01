package org.zhangzhewen.algorithm.sort;

public abstract class Sortable {
    abstract int[] sort(int[] a);

    protected void print() {
        int[] a = new int[]{301, 3, 5, 7, 4, 2, 23};
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (int e : sort(a)) {
            System.out.print(e + " ");
        }
    }

    protected void swap(int[] a, int i, int j) {
        a[j] ^= a[i];
        a[i] ^= a[j];
        a[j] ^= a[i];
    }
}


/*
文章：https://www.jianshu.com/p/4753b10a482c
挺好的一个经典排序攻略：https://github.com/hustcc/JS-Sorting-Algorithm
leetcode排序教程：https://leetcode.cn/leetbook/read/sort-algorithms/evdcgv/
leetcode排序cases：https://leetcode.cn/problems/sort-an-array/

    平均时间复杂度     最好情况    最坏情况    空间复杂度   排序方式    稳定性
冒泡
选择
插入
希尔
归并
快速
推
计数
桶
基数



    平均时间复杂度     最好情况    最坏情况    空间复杂度   排序方式    稳定性
冒泡       n2          n          n2         1          in        y
选择      n2            n2        n2          1          in       n
插入       n2          n          n2         1          in        y
希尔       n1.3       n1.3        n2         1          in        n
归并      nlogn       nlogn       nlogn      n         out       y
快速     nlogn        nlogn       n2        logn       in        n
推        nlogn        nlogn      nlogn      logn      in       n
计数      n+k             n+k      n+k       k          out      y
桶       n+k             n+k        n2      n+k         out      y
基数      nk             nk          nk       n+k         out      y



 Ω()   θ()        最好时间复杂度 平均时间复杂度 最坏时间复杂度 最坏空间复杂度      稳定性
quick sort
merge sort
tim sort
heap sort
bubble sort
insertion sort
tree sort
shell sort
bucket sort
radix sort      
counting sort   
cubesort


*/

