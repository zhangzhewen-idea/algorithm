package org.zhangzhewen.algorithm.combination;

import java.util.*;

// todo 没做出来，下列时间复杂度太高
public class 下一个排列31 {
    public static void main(String[] args) {
        new 下一个排列31().nextPermutation(new int[]{1, 2, 3});
    }

    public void nextPermutation(int[] nums) {
        Map<Integer, int[]> allPermutation = new TreeMap();
        permutation(allPermutation, nums, 0);

        /*for (Map.Entry<Integer, int[]> e : allPermutation.entrySet()) {
            System.out.println();
            System.out.print(e.getKey() + ": ");
            for (int j = 0; j < e.getValue().length; j++) {
                System.out.print(e.getValue()[j] + " ");
            }
        }*/
        int[] res = null;
        Iterator<Map.Entry<Integer, int[]>> ite = allPermutation.entrySet().iterator();
        while(ite.hasNext()){
            if(ite.next().getKey().equals(convert(nums))){
                if(ite.hasNext()){
                    res = ite.next().getValue();
                }else{
                    res = allPermutation.entrySet().iterator().next().getValue();
                }
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }

        System.out.println();
    }

    void permutation(Map<Integer, int[]> allPermutation, int[] nums, int start) {
        if (start == nums.length) {
            allPermutation.put(convert(nums), nums.clone());
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permutation(allPermutation, nums, start + 1);
            swap(nums, i, start);
        }
    }

    int convert(int[] a) {
        int res = 0;
        int aux = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res += (a[i] * aux);
            aux = aux * 10;
        }
        return res;
    }

    void print(int[] nums) {
        System.out.println();
        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " ");
        }
    }

    void swap(int a[], int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
