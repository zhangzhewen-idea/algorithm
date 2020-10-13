package org.zhangzhewen.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组的相对排序1122
 *
 * @author zhangzhewen
 * @date 2020/10/12
 */
public class 数组的相对排序1122 {

    public static void main(String[] args) {
        new 数组的相对排序1122().relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6}
        );
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preAndCountMap = new HashMap();
        int pre = 0,count =0;
        preAndCountMap.put(0,1);
        for(int i = 0 ;i<nums.length;i++){
            pre += nums[i];
            if(preAndCountMap.containsKey(pre-k)){
                count += preAndCountMap.get(pre-k);
            }
            preAndCountMap.put(pre-k,preAndCountMap.getOrDefault(pre-k,0)+1);
        }
        return count;
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length+arr2.length];
        Map<Integer,Integer> arr1Map =new HashMap();
        for(int i = 0 ; i < arr1.length;i++){
            Integer e = arr1Map.get(arr1[i]);
            if(e==null){
                arr1Map.put(arr1[i],1);
            }else{
                arr1Map.put(arr1[i],e+1);
            }
        }
        int diffSize = 0,sameSize = 0;
        for(int i = 0 ;i < arr2.length ; i++){
            Integer count = arr1Map.get(arr2[i]);
            if(count==null){

            }else{
                while(count-->0){
                    res[sameSize++]=arr2[i];
                }
                arr1Map.remove(arr2[i]);
            }
        }

        for(Map.Entry<Integer,Integer> diffEntry : arr1Map.entrySet()){
            int count =diffEntry.getValue();
            while(count-->0){
                int lastElementPosition = sameSize+diffSize;
                int j = lastElementPosition;
                while(j>sameSize&&diffEntry.getKey()<res[j-1]){
                    res[j] = res[j-1];
                    j--;
                }
                res[j]=diffEntry.getKey();
                diffSize++;
            }
        }
        return Arrays.copyOf(res,sameSize+diffSize);
    }

}
