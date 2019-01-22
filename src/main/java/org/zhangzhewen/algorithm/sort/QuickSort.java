package org.zhangzhewen.algorithm.sort;

public class QuickSort extends Sortable{

    @Override
    public int[] sort(int[] a) {
        return quickSort(a,0,a.length-1);
    }

    private int[] quickSort(int[] a,int left,int right){
        if(left<right){
            int partitionIndex = partition(a,left,right);
            quickSort(a,left,partitionIndex-1);
            quickSort(a,partitionIndex+1,right);
        }
        return a;
    }

    private int partition(int[] a,int left,int right){
        int pivot = left;
        int index= pivot+1;
        for(int i = index ; i <= right ; i ++){
            if(a[i] < a[pivot]){
                swap(a,i,index);
                index++;
            }
        }
        swap(a,pivot,index-1);
        return index-1;
    }

    private void swap(int[]a ,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public static void main(String[] args) {
        new QuickSort().print();
    }


}
