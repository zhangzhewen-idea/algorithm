package org.zhangzhewen.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两个数组的交集II350 {
    public static void main(String[] args) {
        new 两个数组的交集II350().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] longNums = null, shortNums = null;
        if (nums1.length > nums2.length) {
            longNums = nums1;
            shortNums = nums2;
        } else {
            longNums = nums2;
            shortNums = nums1;
        }
        Map<Integer, Integer> longMap = new HashMap();
        Map<Integer, Integer> shortMap = new HashMap();
        for (int i = 0; i < longNums.length; i++) {
            longMap.put(longNums[i], longMap.getOrDefault(longNums[i], 0) + 1);
        }
        for (int i = 0; i < shortNums.length; i++) {
            shortMap.put(shortNums[i], shortMap.getOrDefault(shortNums[i], 0) + 1);
        }
        int[] bucket = new int[longNums.length + 1];
        for (Map.Entry<Integer, Integer> shortEntry : shortMap.entrySet()) {
            Integer longCount = longMap.get(shortEntry.getKey());
            if(longCount!=null){
                int shortCount = shortEntry.getValue();
                int count = Math.min(longCount, shortCount);
                for (int i = 0; i < count; i++) {
                    bucket[0]++;
                    bucket[bucket[0]] = shortEntry.getKey();
                }
            }
        }
        return Arrays.copyOfRange(bucket, 1, bucket[0]+1);
    }
}
