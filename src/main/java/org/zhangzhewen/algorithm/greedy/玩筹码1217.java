package org.zhangzhewen.algorithm.greedy;

/**
 * 玩筹码1217
 *
 * @author zhangzhewen
 * @date 2020/10/21
 */
public class 玩筹码1217 {

    public static void main(String[] args) {
        new 玩筹码1217().minCostToMoveChips(new int[]{2, 2, 2, 2, 2, 2, 2});
    }

    public int minCostToMoveChips(int[] position) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= position.length; i++) {
            int currentPosition = position[i - 1];
            int min = 0;
            for (int j = 1; j <= position.length; j++) {
                int otherPosition = position[j - 1];
                if (Math.abs(otherPosition - currentPosition)%2==1) {
                    min += 1;
                }
            }
            if (min != 0) {
                minCost = Math.min(minCost, min);
            }
        }
        return minCost==Integer.MAX_VALUE?0:minCost;
    }

}
