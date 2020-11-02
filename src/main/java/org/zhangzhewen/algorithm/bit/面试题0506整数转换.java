package org.zhangzhewen.algorithm.bit;

/**
 * 面试题0506整数转换
 *
 * @author zhangzhewen
 * @date 2020/11/2
 */
public class 面试题0506整数转换 {
    public static void main(String[] args) {

    }

    public int convertInteger(int A, int B) {
        int xor = A^B;
        int count = 0;
        while(xor!=0){
            count++;
            xor = xor & (xor-1);
        }
        return count;
    }

}
