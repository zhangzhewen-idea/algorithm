package org.zhangzhewen.algorithm.greedy;

/**
 * 换酒问题1518
 *
 * @author zhangzhewen
 * @date 2020/10/26
 */
public class 换酒问题1518 {
    public static void main(String[] args) {
        new 换酒问题1518().numWaterBottles(15, 4);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            res += (numBottles / numExchange);
            numBottles = (numBottles % numExchange) + (numBottles / numExchange);
        }
        return res;
    }
}
