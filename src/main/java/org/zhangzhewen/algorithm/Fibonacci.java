package org.zhangzhewen.algorithm;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/6/2
 */
public class Fibonacci {
    //2的N次方 递归
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    //记忆化
    public static int fib(int n,int[] memo) {
        if(n==1||n==2){
            return 1;
        }
        else if(memo[n]==0){
            memo[n] = fib(n-1)+fib(n-2);
        }
        return memo[n];
    }

    //动态规划=递归+记忆化
    //动态转移方程= f[n]=f[n-1]+f[n-2]
    public static int fib2(int n){
        int [] arr = new int[n+1];
        arr[1]=1;
        arr[2]=1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    static int fib3(int n){//,int[] memo

        return 0;
    }






























    public static void main(String[] args) {
        System.out.println(fib3(8));//,new int[9]
    }
}
