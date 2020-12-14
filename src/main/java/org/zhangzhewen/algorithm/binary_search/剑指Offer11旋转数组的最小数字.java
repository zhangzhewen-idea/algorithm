package org.zhangzhewen.algorithm.binary_search;

import java.util.*;

public class 剑指Offer11旋转数组的最小数字 {
    public static void main(String[] args) {
//        new 剑指Offer11旋转数组的最小数字().search(new int[]{1, 3}, 3);
        new 剑指Offer11旋转数组的最小数字().permutation("qwe");
    }public String[] permutation(String s) {
        List<String> res = new ArrayList();
        permutation(res,s.toCharArray(),0);
        String[] ans = new String[res.size()];
        for(int i = 0 ; i < ans.length;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    void permutation(List<String> res,char[] chars,int start){
        if(start==chars.length){
            res.add(new String(chars));
            return;
        }
        for(int i = start;i < chars.length; i ++){
            swap(chars,start,i);
            permutation(res,chars,start+1);
            swap(chars,start,i);
        }
    }
    void swap(char[] chars,int i,int j){
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        if (nums[l] > nums[h]) {
            while (l < h) {
                int pivot = l + (h - l) / 2;
                if (nums[pivot] > nums[h]) {
                    l = pivot + 1;
                } else {
                    h = pivot;
                }
            }
            return l;
        }
        while (l <= h) {
            int pivot = l + (h - l) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                h = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }
        return -1;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] > target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[l];
    }

    public boolean lemonadeChange(int[] bills) {
        LinkedList<Integer> wallet = new LinkedList();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                add(wallet, bills[i]);
            } else {
                int curMoney = bills[i];
                Iterator<Integer> ite = wallet.iterator();
                while (ite.hasNext()) {
                    if (curMoney == 5) {
                        break;
                    }
                    int m = ite.next();
                    if (curMoney - m >= 5) {
                        curMoney -= m;
                        ite.remove();
                    }
                }
                if (curMoney == 5) {
                    add(wallet, bills[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    void add(LinkedList wallet, int money) {
        if(wallet.isEmpty()){
            wallet.add(money);
            return;
        }
        ListIterator<Integer> ite = wallet.listIterator();
        while (ite.hasNext() && ite.next() > money) {
        }
        ite.previous();
        ite.add(money);
    }

}
