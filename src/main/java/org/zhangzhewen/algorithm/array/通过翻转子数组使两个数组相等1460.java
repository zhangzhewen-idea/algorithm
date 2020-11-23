package org.zhangzhewen.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class 通过翻转子数组使两个数组相等1460 {

    public static void main(String[] args) {
        new 通过翻转子数组使两个数组相等1460().canBeEqual(new int[]{1,1,1,1,1},new int[]{1,1,1,1,1});
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> map = new HashMap();
        for(int i : target){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i : arr){
            Integer e = map.get(i);
            if(e==null || e==0){
                return false;
            }
            map.put(i,e-1);
        }
        return !map.values().stream().anyMatch(o->o>0);
    }

}
