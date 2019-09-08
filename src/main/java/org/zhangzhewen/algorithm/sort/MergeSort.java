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

        return merge2(sort(left),sort(right));
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

    @Override
    int[] sort(int[] a) {

        s(a,0,a.length-1);
        return a;
    }

    void s(int[] a,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int mid= lo+(hi-lo)/2;
        s(a,lo,mid);
        s(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    void merge(int[] nums,int lo,int mid,int hi){
        int[] copy = nums.clone();
        int k = lo,i = lo,j = mid+1;
        while(k<=hi){
            if(i>mid){
                nums[k++]=copy[j++];
            }else if(j > hi){
                nums[k++] = copy[i++];

            }else if(copy[j]<copy[i]){
                nums[k++]=copy[j++];
            }else{
                nums[k++] = copy[i++];
            }
        }



    }


































    public static void main(String[] args) {
        new MergeSort().print();
    }
}
