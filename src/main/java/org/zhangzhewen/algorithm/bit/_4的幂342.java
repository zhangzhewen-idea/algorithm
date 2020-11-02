package org.zhangzhewen.algorithm.bit;

/**
 * _4的幂342
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * @author zhangzhewen
 * @date 2020/11/2
 */
public class _4的幂342 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16*4));
        System.out.println(Integer.toBinaryString(4));
    }
    public boolean isPowerOfFour(int num) {
        if( (num&(-num))==0 && num>=4 ){
            return true;
        }
        return false;
    }
}
