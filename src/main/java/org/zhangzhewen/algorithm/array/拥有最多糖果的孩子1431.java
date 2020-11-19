package org.zhangzhewen.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class 拥有最多糖果的孩子1431 {
    public static void main(String[] args) {
        new 拥有最多糖果的孩子1431().kidsWithCandies(
                new int[]{7, 2, 5, 6, 9, 9, 4, 5}, 3
        );
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        int currentMax = candies[0];

        for(int i = (len&1)==1?1:0 ; i < candies.length; i+=2){
            if(candies[i]<=candies[i+1]&&currentMax<candies[i+1]){
                currentMax = candies[i+1];
            }else if(candies[i+1]<=candies[i]&&currentMax<candies[i]){
                currentMax = candies[i];
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < candies.length ;i ++){
            res.add(candies[i]+extraCandies >= currentMax);
        }

        return res;
    }
}
