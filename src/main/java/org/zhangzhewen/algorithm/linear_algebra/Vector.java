package org.zhangzhewen.algorithm.linear_algebra;

import lombok.Data;
import org.jblas.DoubleMatrix;

import java.util.Iterator;

/**
 * Vector
 *
 * @author zhangzhewen
 * @date 2019/10/3
 */
@Data
public class Vector implements Iterable<Double>{
    private double[] list;
    public Vector(double[] list){
        this.list = list.clone();
    }

    public int len(){
        return list.length;
    }

    public double getItem(int index){
        return list[index];
    }

    public Vector add(Vector another){
        assert len() == another.len();
        double[] result = new double[len()];
        int index = 0;
        for (double i : another) {
            result[index] = list[index]+i;
            index++;
        }
         return new Vector(result);
    }

    public Vector sub(Vector another){
        assert len() == another.len();
        double[] result = new double[len()];
        int index = 0;
        for (double i : another) {
            result[index] = list[index]-i;
            index++;
        }
        return new Vector(result);
    }

    //数量乘
    public Vector mul(double k){
        double[] result = new double[len()];
        for (int i = 0; i < result.length; i++) {
            result[i] = k*list[i];
        }

        return new Vector(result);
    }

    //点乘、内积
    public double dot(Vector another){
        assert len() == another.len();

        double result = 0;
        int index = 0;
        for (double i : another) {
            result += i*list[index];
            index++;
        }

        return result;

    }

    public Vector pos(){
        double[] result = new double[len()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.abs(list[i]);
        }

        return new Vector(result);
    }

    public Vector neg(){
        double[] result = new double[len()];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1 * Math.abs(list[i]);
        }

        return new Vector(result);
    }

    public static Vector zero(int dimetion){
        return new Vector(new double[dimetion]);
    }

    //模
    public double norm(){
        double result = 0;
        for (int i = 0; i < len(); i++) {
            result += list[i]*list[i];
        }
        return Math.sqrt(result);
    }

    //单位向量
    public Vector normalize(){
        double[] result = new double[len()];
        double norm = norm();
        if(norm < Constants.EPSILON){
            throw new RuntimeException("normalize error! norm is zero!");
        }
        for (int i = 0; i < len(); i++) {
            result[i] = list[i]/norm;
        }
        return new Vector(result);
    }

    public double[] underlyingList(){
        return this.list.clone();
    }

    public static void main(String[] args) {
        Vector vector = new Vector(new double[]{5,2});
        Vector vector2 = new Vector(new double[]{3,1});
        System.out.println(vector.normalize());

        DoubleMatrix doubleMatrix = new DoubleMatrix(new double[]{5,2});
        DoubleMatrix doubleMatrix2 = new DoubleMatrix(new double[]{3,1});
        System.out.println(doubleMatrix.div(doubleMatrix.norm2()).norm2());

    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return list.length!=index;
            }

            @Override
            public Double next() {
                return list[index++];
            }
        };
    }
}
