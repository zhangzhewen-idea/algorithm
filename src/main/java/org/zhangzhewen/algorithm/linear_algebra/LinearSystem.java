package org.zhangzhewen.algorithm.linear_algebra;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * LinearSystem
 *
 * @author zhangzhewen
 * @date 2019/10/5
 */
//todo 未写完 ：
// todo 可参照：   6-4 实现高斯-约旦消元法 【www.zxit8.com】 .mp4
// todo 可参照：   6-8 实现更一般化的高斯-约旦消元法 【www.zxit8.com】 .mp4
public class LinearSystem {
    private double[][] Ab;
    private int rowNum;
    private int colNum;
    public LinearSystem(Matrix A,Vector b){
        assert A.rowNum() == b.len();
        assert A.rowNum() == A.colNum();//todo no this restriction
        this.rowNum = A.rowNum();
        this.colNum = A.colNum()+1;
        this.Ab = new double[this.rowNum][];
        for (int i = 0; i < this.rowNum; i++) {
//            this.Ab[i] = Arrays.copyOf(A.getList2d()[i],colNum);
            this.Ab[i][this.colNum-1] = b.getItem(i);
        }
    }

    public static void main(String[] args) {
        LinearSystem a = new LinearSystem(new Matrix(new double[][]{{1, 2}, {3, 4}}), new Vector(new double[]{5, 6}));

        System.out.println(a);
    }
}
