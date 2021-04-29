package org.zhangzhewen.algorithm.sort;

public abstract class Sortable {
    abstract int[] sort(int[] a);
    protected void print(){
        int[] a = new int[]{301,3 ,5,7, 4, 2,23};
        for(int e : a){
            System.out.print(e+" ");
        }
        System.out.println();
        for(int e : sort(a)){
            System.out.print(e+" ");
        }
    }
    protected void swap(int[] a,int i,int j){
        a[j] ^= a[i];
        a[i] ^= a[j];
        a[j] ^= a[i];
    }
}


/*
文章：https://www.jianshu.com/p/4753b10a482c

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

