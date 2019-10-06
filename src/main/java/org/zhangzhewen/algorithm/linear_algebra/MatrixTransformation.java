package org.zhangzhewen.algorithm.linear_algebra;

import com.github.sh0nk.matplotlib4j.Plot;
import org.jblas.DoubleMatrix;
import org.jblas.Solve;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * MatrixTransformation
 *
 * @author zhangzhewen
 * @date 2019/10/5
 */
public class MatrixTransformation {
    //英文F的点坐标
    public static double[][] fPoints = new double[][]{
            {0, 0},
            {0, 5},
            {3, 5},
            {3, 4},
            {1, 4},

            {1, 3},
            {2, 3},
            {2, 2},
            {1, 2},
            {1, 0}
    };

    public static void main(String[] args) throws Exception{
        List<Double> x = Arrays.stream(fPoints).map(o->o[0]).collect(Collectors.toList());
        List<Double> y = Arrays.stream(fPoints).map(o->o[1]).collect(Collectors.toList());
        Plot plt = Plot.create();
        plt.xlim(-10,10);
        plt.ylim(-10,10);
        plt.plot().add(x,y);

        //先定义函数矩阵
        //缩放
//        Matrix T = new Matrix(new double[][]{{2,0},{0,1.5}});
        //翻转
//        Matrix T = new Matrix(new double[][]{{1,0},{0,-1}});
//        Matrix T = new Matrix(new double[][]{{-1,0},{0, 1}});
//        Matrix T = new Matrix(new double[][]{{-1,0},{0, -1}});
        //错切
//        Matrix T = new Matrix(new double[][]{{1,0.5},{0, 1}});
//        Matrix T = new Matrix(new double[][]{{1,0},{0.5 , 1}});
        //旋转
        double theta = Math.PI / 3;//定义弧度，计算机库中一般用弧度(1/3 * PI)来表示，而 生活中用角度(60°)来表示
        Matrix T = new Matrix(new double[][]{{Math.cos(theta),Math.sin(theta)},
                {-Math.sin(theta) , Math.cos(theta)}});


        Matrix P = new Matrix(fPoints);
        Matrix P2 = T.dot(P.T()).T();
        plt.plot().add(
                Stream.of(P2.getList2d()).map(o->o[0]).collect(Collectors.toList()),
                Stream.of(P2.getList2d()).map(o->o[1]).collect(Collectors.toList())
                );

//        plt.show();
        /*
        示例
        Plot plt = Plot.create();
        plt.plot()
                .add(Arrays.asList(1.3, 2))
                .label("label")
                .linestyle("--");
        plt.xlabel("xlabel");
        plt.ylabel("ylabel");
        plt.text(0.5, 0.2, "text");
        plt.title("Title!");
        plt.legend();
        plt.show();*/


        //求逆矩阵
        DoubleMatrix doubleMatrix = new DoubleMatrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        System.out.println(Solve.pinv(doubleMatrix));
        System.out.println(Solve.solve(doubleMatrix,DoubleMatrix.eye(doubleMatrix.rows)));
    }
}
