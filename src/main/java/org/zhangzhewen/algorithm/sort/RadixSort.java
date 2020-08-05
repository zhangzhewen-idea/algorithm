package org.zhangzhewen.algorithm.sort;

import java.util.*;

import java.util.Arrays;

public class RadixSort {

    private static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    private static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    private static void radixsort(int[] arr, int n) {

        int m = getMax(arr, n);


        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }


    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    static void radixsort2(int[] a,int len){

    }































    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort2(arr, n);
        print(arr, n);
    }
}
// Written by James Mc Dermott(theycallmemac)

class RadixSort2 extends Sortable {

    private static int getDigit (int[] array){
        //Getting Max Int at first.
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(max<array[i]){
                max = array[i];
            }
        }
        //Calculating digit by Max Int.
        int digit=1;
        for (int i = max; i!=0; i/=10) {
            digit*=10;
        }
        return digit;
    }

    private static void radixSort(int[] array)
    {
        int d = getDigit(array);

        int n=1;//代表位数对应的数：1,10,100...
        int k=0;//保存每一位排序后的结果用于下一位的排序输入
        int length=array.length;
        int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order=new int[10];//用于保存每个桶里有多少个数字
        while(n<d)
        {
            for(int num:array) //将数组array里的每个数字放在相应的桶里
            {
                int digit=(num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            for(int i=0;i<length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for(int j=0;j<order[i];j++)
                    {
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i]=0;//将桶里计数器置0，用于下一次位排序
            }
            n*=10;
            k=0;//将k置0，用于下一轮保存位排序结果
        }

    }
    public static void main(String[] args)
    {
        /*int[] A=new int[]{1733,22, 93, 643, 55, 14, 28, 65, 39, 81};
        radixSort(A);
        for(int num:A)
        {
            System.out.println(num);
        }*/


        new RadixSort2().print();
    }



    public int[] sort(int[] a) {


        return a;
    }




































}
