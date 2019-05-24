package org.zhangzhewen.algorithm;

import java.util.*;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/2/5
 */
public class LeetCode {

    public static void main(String[] args) {
        twoSum(new int[]{3,2,4},6);

//        int[] result = maxSlidingWindow2(new int[]{1,10,2,-1,3},2);
//        //期望的是 10 10 2 3
//        for(int i = 0;i<result.length;i++){
//            System.out.print(result[i]+" ");
//        }
//
//        isAnagram("aacc",
//                "ccac");
//        System.out.println(bsearch(new int[]{-2,-1, 0, 1, 2, 3, 4, 5}, 4));





    }

    public static Map<Integer,Integer> twoSum(int[] a,int target){
        Map<Integer,Integer> result = new HashMap<>();
        Map<Integer,Integer> valueAndIndex = new HashMap<>();
        for(int i = 0 ; i < a.length;i++){
            valueAndIndex.put(a[i],i);
        }
        for(int i = 0 ; i < a.length;i++){
            Integer anotherIndex = valueAndIndex.get(target-a[i]);
            if(anotherIndex.intValue()!=i){
                result.put(i,anotherIndex);
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        Deque<Integer> window = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //移除窗口外元素
            if (i >= k && window.getFirst() <= i - k) {
                window.removeFirst();
            }
            while (window.size() > 0 && nums[window.getLast()] <= nums[i]) {
                window.removeLast();
            }
            window.add(i);
            if (i >= k - 1) {
                result.add(nums[window.getFirst()]);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }






    //二分查找的while实现
    public static int bsearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int bsearch2(int[] a,int n){

        //todo
        return -1;
    }

















    // 二分查找的递归实现
    public int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }
    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else if (a[mid] > value) {
            return bsearchInternally(a, low, mid - 1, value);
        } else {
            return mid;
        }
    }













    public static boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            Integer v = map.get(k);
            if (v == null) {
                map.put(k, 1);
            } else {
                map.put(k, ++v);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            Integer v = map.get(a);
            if (v == null || --v == -1) {
                return false;
            }
            map.put(a, v);
        }
        return true;
    }

    public static double myPow(double x,int n){
        /*//recurse
        if(n==0){
            return 1;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n&1)==1?x*myPow(x,n-1):myPow(x*x,n/2);*/
        //while
        if(n<0){
            n = -n;
            x = 1/x;
        }
        double pow = 1;
        while(n>0){
            if((n&1)==1){
                pow *= x;
            }
            n >>= 1;
            x *= x;
        }
        return pow;
    }

}
