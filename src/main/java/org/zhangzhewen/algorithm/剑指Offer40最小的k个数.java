package org.zhangzhewen.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指Offer40最小的k个数
 *
 * @author zhangzhewen
 * @date 2020/10/20
 */
public class 剑指Offer40最小的k个数 {

    public static void main(String[] args) {

    }
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue priorityQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int k1 = k;
        for(int a : arr){
            priorityQueue.offer(a);
            if(k1==0){
                priorityQueue.poll();
            }else {
                k1--;
            }
        }
        int[] res = new int[k];
        Object[] a = priorityQueue.toArray();
        for(int i = 0;i<k;i++){
            res[i] = (int)a[i];
        }
        return res;
    }

}
