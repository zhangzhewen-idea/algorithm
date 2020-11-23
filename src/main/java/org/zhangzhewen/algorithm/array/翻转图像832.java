package org.zhangzhewen.algorithm.array;

public class 翻转图像832 {

    public static void main(String[] args) {
        new 翻转图像832().flipAndInvertImage(new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        });
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int aux = A[i][j] ^ 1;
                A[i][j] = A[i][A[0].length - j - 1] ^ 1;
                A[i][A[0].length - j - 1] = aux;
            }
        }
        return A;
    }

}
