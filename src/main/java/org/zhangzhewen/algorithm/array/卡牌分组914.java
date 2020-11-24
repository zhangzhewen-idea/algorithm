package org.zhangzhewen.algorithm.array;

import java.util.Arrays;

public class 卡牌分组914 {
    public static void main(String[] args) {
        System.out.println(gcd(18, 8));
        System.out.println(gcd(8, 18));
//        int[] a = new int[]{1,2,3,4,4,3,2,1};
//        int[] a = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        int[] a = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        new 卡牌分组914().hasGroupsSizeX(a);
    }

    // 求最大公约数 辗转相除法
    static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==0 || deck.length==1){
            return false;
        }
        // 先计数
        int[] count = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }
        int g = -1;
        for (int i = 0; i < count.length; i++) {
            if(count[i]>0){
                if(g==-1){
                    g = count[i];
                }
                else{
                    g = gcd(g,count[i]);
                    if(g==1){
                        return false;
                    }
                }
            }
        }
        return g>=2;
    }
}
