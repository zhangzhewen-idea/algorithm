package org.zhangzhewen.algorithm.sort;

public class HeapSort extends Sortable{

    public int[] sort2(int[] a) {
        int len = a.length;
        buildMaxHeap(a,len);
        for(int i=len-1;i>0;i--){
            swap(a,0,i);
            len--;
            heapify(a,0,len);
        }
        return a;
    }

    private void buildMaxHeap(int[] a,int len){
        for(int i = len/2;i>=0;i--){
            heapify(a,i,len);
        }
    }

    private void heapify(int[] a,int i,int len){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if(left<len && a[left]>a[largest]){
            largest = left;
        }
        if(right < len && a[right] > a[largest]){
            largest = right;
        }
        if(largest != i ){
            swap(a,i,largest);
            heapify(a,largest,len);
        }
    }













    public int[] sort(int[] a){


        return a;
    }







    public static void main(String[] args) {
        new HeapSort().print();
    }


}
