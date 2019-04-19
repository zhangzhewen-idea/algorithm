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

        if(a.length<2){
            return a;
        }

        int mid = a.length/2;
        int[] l = Arrays.copyOfRange(a,0,mid);
        int[] r = Arrays.copyOfRange(a,mid,a.length);
        return merge(sort(l),sort(r));
    }

    int[] merge(int[] l,int[] r){
        int[] res = new int[l.length+r.length];
        int li = 0,ri=0,index = 0;
        while(li<l.length&&ri<r.length&&index<res.length){
            if(l[li]<r[ri]){
                res[index++]=l[li++];
            }else{
                res[index++]=r[ri++];
            }
        }
        while(li<l.length){
            res[index++]=l[li++];
        }
        while(ri<r.length){
            res[index++]=r[ri++];
        }

        return res;
    }


































    public static void main(String[] args) {
        new MergeSort().print();
    }
}
