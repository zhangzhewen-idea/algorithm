package org.zhangzhewen.algorithm.sort;

public abstract class Sortable {
    abstract int[] sort(int[] a);
    protected void print(){
        for(int e : sort(new int[]{5, 4,3 , 2,1})){
            System.out.print(e+" ");
        }
    }
}
