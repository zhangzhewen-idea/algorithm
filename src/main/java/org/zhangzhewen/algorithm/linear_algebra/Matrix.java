package org.zhangzhewen.algorithm.linear_algebra;

import lombok.Data;
import lombok.ToString;
import org.jblas.DoubleMatrix;
import org.jblas.Solve;

/**
 * Matrix
 *
 * @author zhangzhewen
 * @date 2019/10/4
 */
@Data
public class Matrix {
    private double[][] list2d;

    public Matrix(double[][] list2d) {
        this.list2d = list2d.clone();
    }

    public double[][] underlyingList(){
        return this.list2d.clone();
    }

    public static Matrix identity(int n) {
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }
        return new Matrix(result);
    }

    public Vector rowVector(int index) {
        return new Vector(list2d[index]);
    }

    public Vector colVector(int index) {
        int[] shape = this.shape();
        double[] result = new double[shape[0]];
        for (int i = 0; i < shape[0]; i++) {
            result[i] = list2d[i][index];
        }
        return new Vector(result);
    }

    public Matrix T() {
        int[] shape = shape();
        double[][] result = new double[shape[1]][shape[0]];
        for (int i = 0; i < shape[1]; i++) {
            int index = 0;
            for (double e : this.colVector(i)) {
                result[i][index] = e;
                index++;
            }
        }

        return new Matrix(result);
    }

    public Matrix add(Matrix another) {
        int[] shape = this.shape();
        double[][] result = new double[shape[0]][shape[1]];
        for (int i = 0; i < shape[0]; i++) {
            for (int j = 0; j < shape[1]; j++) {
                result[i][j] = this.list2d[i][j] + another.list2d[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix sub(Matrix another) {
        int[] shape = this.shape();
        double[][] result = new double[shape[0]][shape[1]];
        for (int i = 0; i < shape[0]; i++) {
            for (int j = 0; j < shape[1]; j++) {
                result[i][j] = this.list2d[i][j] - another.list2d[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix mul(double k) {
        int[] shape = this.shape();
        double[][] result = new double[shape[0]][shape[1]];
        for (int i = 0; i < shape[0]; i++) {
            for (int j = 0; j < shape[1]; j++) {
                result[i][j] = this.list2d[i][j] * k;
            }
        }
        return new Matrix(result);
    }

    public Vector dot(Vector another) {
        int[] shape = this.shape();
        double[] result = new double[shape[1]];
        for (int i = 0; i < shape[0]; i++) {
            result[i] = this.rowVector(i).dot(another);
        }
        return new Vector(result);
    }

    public Matrix dot(Matrix another) {
        int[] shape = this.shape();
        double[][] result = new double[shape[0]][another.shape()[1]];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = this.rowVector(i).dot(another.colVector(j));
            }
        }
        return new Matrix(result);
    }

    public Matrix div(double k) {
        return mul(1 / k);
    }

    public int size() {
        int[] s = shape();
        return s[0] * s[1];
    }

    public int rowNum() {
        return shape()[0];
    }

    public int colNum() {
        return shape()[1];
    }

    public int[] shape() {
        return new int[]{list2d.length, list2d[0].length};
    }

    public double getItem(int row, int col) {
        return list2d[row][col];
    }

    public Matrix pos() {
        return mul(1);
    }

    public Matrix neg() {
        return mul(-1);
    }

    public static Matrix zero(int row, int col) {
        return new Matrix(new double[row][col]);
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Matrix matrix2 = new Matrix(new double[][]{{5.0, 6.0}, {7.0, 8.0}});
        Matrix T = new Matrix(new double[][]{{1.5, 0}, {0, 2}});
        Matrix P = new Matrix(new double[][]{{0, 4, 5}, {0, 0, 3}});
        Vector vector = new Vector(new double[]{5, 3});
        System.out.println(matrix.dot(matrix2));
        System.out.println(matrix2.dot(matrix));
        System.out.println(P.T());
        System.out.println(Matrix.identity(2).dot(matrix));




    }
}
