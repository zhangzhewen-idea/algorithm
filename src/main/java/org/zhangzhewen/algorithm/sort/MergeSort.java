package org.zhangzhewen.algorithm.sort;

import java.util.Arrays;

public class MergeSort extends Sortable{

    public int[] sort2(int[] a) {

        if(a.length<2){
            return a;
        }

        int middle = a.length / 2;
        int[] left = Arrays.copyOfRange(a,0,middle);
        int[] right = Arrays.copyOfRange(a,middle,a.length);

        return merge(sort(left),sort(right));
    }

    private int[] merge2(int[] left,int[] right){

        int[] result = new int[left.length+right.length];
        int i=0,l=0,r=0;
        while(i<result.length&&l<left.length&&r<right.length){
            if(left[l]>right[r]){
                result[i++]=right[r++];
            }else{
                result[i++]=left[l++];
            }
        }
        while(l<left.length){
            result[i++]=left[l++];
        }
        while(r<right.length){
            result[i++]=right[r++];
        }
        return result;
    }

    public int[] sort(int[] a){
        if(a.length<2){
            return a;
        }
        int mid = a.length/2;
        int[] r = Arrays.copyOfRange(a,0,mid);
        int[] l = Arrays.copyOfRange(a,mid,a.length);
        return merge2(sort(r),sort(l));
    }

    public int[] merge(int[] right,int[] left){
        int [] result = new int[right.length+left.length];
        int r=0,l=0,i =0;
        while(i<result.length&&r<right.length&&l<left.length){
            if(right[r]>left[l]){
                result[i++]=left[l++];
            }else{
                result[i++]=right[r++];
            }
        }
        while(r<right.length){
             result[i++] = right[r++];
        }
        while(l<left.length){
            result[i++] = left[l++];
        }
        return result;
    }



















    public static void main(String[] args) {
        new MergeSort().print();
    }


}
