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
        twoSum(new int[]{3,2,4},7);

        isValid("()");
//        int[] result = maxSlidingWindow2(new int[]{1,10,2,-1,3},2);
//        //期望的是 10 10 2 3
//        for(int i = 0;i<result.length;i++){
//            System.out.print(result[i]+" ");
//        }
//
//        isAnagram("aacc",
//                "ccac");
//        System.out.println(bsearch2(new int[]{-2,-1, 0, 1, 2, 3, 4, 5}, 4,0,8));


//        int v = 7;
//        System.out.println(josephusProblem(v));


    }

    public static boolean isValid(String s) {
        Map<Character,Character> bracketsMap = new HashMap(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Stack<Character> stack = new Stack();
        Character aux;
        for(char bracket : s.toCharArray()){
            aux = bracketsMap.get(bracket);
            if(aux==null){
                stack.push(bracket);
            }else if(!stack.isEmpty()){
                if(stack.peek().equals(aux)){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }else {
                return false;
            }
        }

        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }


    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> valueAndIndexMap = new HashMap();
        for(int i = 0 ; i < nums.length;i ++){
            Integer resultIndex = valueAndIndexMap.get(target - nums[i]);
            if(resultIndex!=null){
                return new int[]{resultIndex,i};
            }
            valueAndIndexMap.put(nums[i],i);
        }
        return null;
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

    public static int bsearch2(int[] a,int n,int l,int r){
        if(l>r){
            return -1;
        }
        int mid = l+(r-l)/2;
        if(a[mid]>n){
            return bsearch2(a,n,l,mid+1);
        }
        else if(a[mid]<n){
            return bsearch2(a,n,mid-1,r);
        }else{
            return mid;
        }
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

    public static int josephusProblem(List<Integer> a){
        /*//brute
        int index = 1;
        while(a.size()>1){
            Iterator<Integer> b = a.iterator();
            while (b.hasNext()) {
                b.next();
                if( (index++&1)==0){
                    b.remove();
                }
            }

        }*/
        return a.get(0);
    }

    public static int josephusProblem(int a){
        if(a==3){
            return 3;
        }
        return ( (a&1)==1)?2*josephusProblem(a/2)+1:2*josephusProblem(a/2)-1;
    }

}
