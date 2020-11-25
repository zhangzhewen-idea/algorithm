package org.zhangzhewen.algorithm.array;

public class 种花问题605 {
    public static void main(String[] args) {
//        new 种花问题605().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2);
//        new 种花问题605().canPlaceFlowers(new int[]{1}, 0);
//        new 种花问题605().canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1);
        new 种花问题605().canPlaceFlowers(new int[]{1, 0}, 1);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
                    n--;
                }
            }
        }
        return n==0;
    }

}
