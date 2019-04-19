package org.zhangzhewen.algorithm.sort;

public class QuickSort extends Sortable{

    public int[] sort2(int[] a) {
        return quickSort2(a,0,a.length-1);
    }

    private int[] quickSort2(int[] a,int left,int right){
        if(left<right){
            int partitionIndex = partition2(a,left,right);
            quickSort2(a,left,partitionIndex-1);
            quickSort2(a,partitionIndex+1,right);
        }
        return a;
    }

    private int partition2(int[] a,int left,int right){
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


    public int[] sort(int[] a){

        quickSort(a,0,a.length-1);




       return a;
    }

    public void quickSort(int[] a,int l,int r){
        if(l>=r){
            return;
        }
        int p = partition(a,l,r);
        quickSort(a,l,p-1);
        quickSort(a,p+1,r);
    }

    public int partition(int[] a,int l,int r){
        int pivot = l;
        int index = l+1;
        for(int i = index;i <=r;i++){
            if(a[i]<a[pivot]){
                swap(a,i,index++);
            }
        }

        swap(a,pivot,index-1);
        return index-1;
    }



































    public static void main(String[] args) {
        new QuickSort().print();
    }


}
