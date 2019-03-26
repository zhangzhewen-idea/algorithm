package org.zhangzhewen.algorithm.sort;

public abstract class Sortable {
    abstract int[] sort(int[] a);
    protected void print(){
        for(int e : sort(new int[]{3 ,5,1, 4, 2})){
            System.out.print(e+" ");
        }
    }
}
