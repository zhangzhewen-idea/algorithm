package org.zhangzhewen.algorithm.sort;

public abstract class Sortable {
    abstract int[] sort(int[] a);
    protected void print(){
        for(int e : sort(new int[]{3 ,5,7, 4, 2})){
            System.out.print(e+" ");
        }
    }
    protected void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
