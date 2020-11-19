package org.zhangzhewen.algorithm.array;

import java.util.LinkedList;
import java.util.List;

public class 按既定顺序创建目标数组138 {

    public static void main(String[] args) {

    }

    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> list = new LinkedList();
        for(int i = 0 ; i < nums.length ; i ++){
            list.add(index[i],nums[i]);
        }
        for(int i =0 ; i< nums.length ; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

}
