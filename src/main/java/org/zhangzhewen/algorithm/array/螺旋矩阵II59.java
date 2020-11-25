package org.zhangzhewen.algorithm.array;

public class 螺旋矩阵II59 {
    public static void main(String[] args) {
        int[][] x = new 螺旋矩阵II59().generateMatrix(3);
        System.out.println(x);
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int len = n - 1, left = 0, right = len, top = 0, bottom = len;
        int v = 1;
        while(left<=right){
            for (int i = left; i <= right ; i++) {
                ans[top][i] = v++;
            }
            for (int i = top+1; i <= bottom ; i++) {
                ans[i][right] = v++;
            }
            for (int i = right-1; i >= left ; i--) {
                ans[bottom][i]=v++;
            }
            for (int i = bottom-1; i > top ; i--) {
                ans[i][left]=v++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

}
