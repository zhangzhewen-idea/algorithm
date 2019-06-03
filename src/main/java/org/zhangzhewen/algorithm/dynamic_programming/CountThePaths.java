package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/6/3
 */
public class CountThePaths {
    //true：空地，false：石头
    static boolean[][] map = new boolean[][]{
            {true,true,true,true,true,true,true,true},
            {true,true,false,true,true,true,false,true},
            {true,true,true,true,false,true,true,true},
            {false,true,false,true,true,false,true,true},
            {true,true,false,true,true,true,true,true},
            {true,true,true,false,false,true,false,true},
            {true,false,true,true,true,false,true,true},
            {true,true,true,true,true,true,true,true}
    };

    static int[][] result = new int[map.length][map[0].length];

    public static void main(String[] args) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j]=1;
            }
        }

        int rowInitIndex = result.length-1;
        int colInitIndex = result[0].length-1;

        for (int rowIndex = rowInitIndex; rowIndex >=0 ; rowIndex--) {
            for (int colIndex = colInitIndex; colIndex >= 0 ; colIndex--) {
                //跳过目的地
                if(rowIndex==rowInitIndex && colIndex==colInitIndex){
                    continue;
                }

                //如果是空地
                if(map[rowIndex][colIndex]){
                    //下方格子值 加上 右边格子值 ，而且需要判断 越界的情况
                    int downVal = (rowIndex+1 >rowInitIndex)?0:result[rowIndex+1][colIndex];
                    int rightVal = (colIndex+1> colInitIndex)?0:result[rowIndex][colIndex+1];
                    result[rowIndex][colIndex] = downVal+rightVal;
                }
                //如果是石头
                else{
                    result[rowIndex][colIndex] = 0;
                }
            }
        }

        //最后的总的走法数量 就是 第一个格子。
        System.out.println(result[0][0]);
    }

}
