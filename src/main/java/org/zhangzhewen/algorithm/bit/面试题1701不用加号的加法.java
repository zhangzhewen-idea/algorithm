package org.zhangzhewen.algorithm.bit;

/**
 * 面试题1701不用加号的加法
 *
 *
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author zhangzhewen
 * @date 2020/10/29
 */
public class 面试题1701不用加号的加法 {

    public static void main(String[] args) {
        System.out.println(new 面试题1701不用加号的加法().add(5,3));
    }

    public int add(int a, int b) {
        while(b!=0){
            int carry = (a&b)<<1;
            a ^= b;
            b = carry;
        }
        return a;
    }

}
