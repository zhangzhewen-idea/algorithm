package org.zhangzhewen.algorithm.sort;

/**
 * BitonicSort
 *
 * @author zhangzhewen
 * @date 2020/7/28
 */
/*
说明：https://www.jianshu.com/p/ea4a62fdaae9
【双调排序】是data-independent的排序， 即比较顺序与数据无关的排序方法， 特别适合做并行计算，例如用GPU、fpga来计算。
他属于【排序网络】https://www.jianshu.com/p/2b06f4b0302e

Java program for Bitonic Sort. Note that this program
works only when size of input is a power of 2. */
public class BitonicSort {
    /* The parameter dir indicates the sorting direction,
    ASCENDING or DESCENDING; if (a[i] > a[j]) agrees
    with the direction, then a[i] and a[j] are
    interchanged. */
    void compAndSwap(int a[], int i, int j, int dir) {
        if ((a[i] > a[j] && dir == 1) ||
                (a[i] < a[j] && dir == 0)) {
            // Swapping elements
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* It recursively sorts a bitonic sequence in ascending
    order, if dir = 1, and in descending order otherwise
    (means dir=0). The sequence to be sorted starts at
    index position low, the parameter cnt is the number
    of elements to be sorted.*/
    void bitonicMerge(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(a, i, i + k, dir);
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    /* This funcion first produces a bitonic sequence by
    recursively sorting its two halves in opposite sorting
    orders, and then calls bitonicMerge to make them in
    the same order */
    void bitonicSort(int a[], int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;

            // sort in ascending order since dir here is 1
            bitonicSort(a, low, k, 1);

            // sort in descending order since dir here is 0
            bitonicSort(a, low + k, k, 0);

            // Will merge wole sequence in ascending order
            // since dir=1.
            bitonicMerge(a, low, cnt, dir);
        }
    }

    /*Caller of bitonicSort for sorting the entire array
    of length N in ASCENDING order */
    void sort(int a[], int N, int up) {
        bitonicSort(a, 0, N, up);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void sort2(int a[],int N,int up){
    }








































    public static void main(String args[]) {
        int a[] = {3, 7, 4, 8, 6, 2, 1, 5};
        int up = 1;
        BitonicSort ob = new BitonicSort();
        ob.sort2(a, a.length, up);
        System.out.println("\nSorted array");
        printArray(a);
    }


}
