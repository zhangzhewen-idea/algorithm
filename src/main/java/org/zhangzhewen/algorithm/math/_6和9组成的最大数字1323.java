package org.zhangzhewen.algorithm.math;

public class _6和9组成的最大数字1323 {
    public static void main(String[] args) {
        new _6和9组成的最大数字1323().maximum69Number(9669);
    }
    public int maximum69Number (int num) {
        int aux = num,tmp = 1,adjust = 0;
        while(aux>0){
            if(aux%10==6){
                adjust = tmp * 3;
            }
            tmp *= 10;
            aux /= 10;
        }
        return num+adjust;
    }
}
