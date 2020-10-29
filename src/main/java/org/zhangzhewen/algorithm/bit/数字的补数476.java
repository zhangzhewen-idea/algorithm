package org.zhangzhewen.algorithm.bit;

/**
 * 面试题1607最大数值
 *
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * 示例：
 *
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 * @author zhangzhewen
 * @date 2020/10/29
 */
public class 数字的补数476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));

    }
    public static int findComplement(int num) {
        int maxBitNum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            maxBitNum += 1;
            tmpNum >>= 1;
        }
        return num ^ ((1 << maxBitNum) - 1);
    }

}
