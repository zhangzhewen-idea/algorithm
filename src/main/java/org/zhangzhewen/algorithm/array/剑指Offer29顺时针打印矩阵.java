package org.zhangzhewen.algorithm.array;

public class 剑指Offer29顺时针打印矩阵 {
    public static void main(String[] args) {
        new 剑指Offer29顺时针打印矩阵().spiralOrder(
                new int[][]{
                        {1, 2,  3,  4},
                        {5, 6,  7,  8},
                        {9, 10, 11, 12}}
        );

      /*  new 剑指Offer29顺时针打印矩阵().spiralOrder(
                new int[][]{
                        {1,  2,  3,  4,  5},
                        {6,  7,  8,  9,  10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}
                }
        );*/
    }

    public int[] spiralOrder (int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int left = 0,right = matrix[0].length-1,top = 0,bottom=matrix.length-1,i=0;
        int[] ans = new int[matrix[0].length*matrix.length];
        while(left<=right){
            for(int column = left;column<=right;column++){
                ans[i++] = matrix[top][column];
            }
            for(int row = top+1;row<=bottom;row++){
                ans[i++] = matrix[row][right];
            }
            for(int column = right-1;column>=left;column--){
                ans[i++] = matrix[bottom][column];
            }
            for(int row = bottom-1;row>top;row--){
                ans[i++] = matrix[row][left];
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

}
