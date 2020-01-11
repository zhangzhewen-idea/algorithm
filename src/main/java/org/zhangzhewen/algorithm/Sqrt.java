package org.zhangzhewen.algorithm;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/29
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt (4));
    }

    public int mySqrt2(int x) {

        return 0;
    }



















    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        //二分法
        /*double l=1;
        double r=x;
        while(l<r){
            double mid = l+((r-l)/2);
            if((int)mid==(int)(x/mid)){
                return (int)mid;
            }else if(mid>x/mid){
                r = mid;
            }else {
                l = mid;
            }
        }
        return -1;*/
        //牛顿迭代法
        if(Integer.MAX_VALUE==x){
            x-=1;
        }
        int r = x;
        while(r>x/r){
            r = (r+x/r)/2;
        }
        return r;
    }
}
