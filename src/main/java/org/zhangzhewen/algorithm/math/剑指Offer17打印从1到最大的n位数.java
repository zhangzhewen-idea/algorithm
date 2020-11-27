package org.zhangzhewen.algorithm.math;

public class 剑指Offer17打印从1到最大的n位数 {
    public static void main(String[] args) {

    }
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10,n)-1;
        int[] ans = new int[end];
        for (int i = 1; i <= end; i++) {
            ans[i-1] = i;
        }
        return ans;
    }
}
