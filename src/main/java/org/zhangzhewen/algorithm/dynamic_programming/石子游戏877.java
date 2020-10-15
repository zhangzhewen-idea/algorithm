package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * 石子游戏877
 *
 * @author zhangzhewen
 * @date 2020/10/14
 */
public class 石子游戏877 {

    public static void main(String[] args) {
        new 石子游戏877().stoneGame(new int[]{5,3,4,5});
    }

    int l,r;
    public boolean stoneGame(int[] piles) {
        return getAlexGameResult(piles,true) || getAlexGameResult(piles,false);
    }
    boolean getAlexGameResult(int[] piles, boolean firstTake){
        l=0;
        r=piles.length-1;
        int firstTakeAmount=action(piles),secondTakeAmount=0;
        for(int i = 0 ; l<=r;i++){
            if( (i&1)==0 ){
                secondTakeAmount += action(piles);
            }else{
                firstTakeAmount += action(piles);
            }
        }
        if(firstTake){
            return firstTakeAmount>secondTakeAmount;
        }else{
            return secondTakeAmount>firstTakeAmount;
        }
    }

    int action(int[] piles){
        if(piles[l]>piles[r]){
            return piles[l++];
        }else{
            return piles[r--];
        }
    }

}
