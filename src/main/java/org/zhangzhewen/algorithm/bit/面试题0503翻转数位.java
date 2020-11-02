package org.zhangzhewen.algorithm.bit;

/**
 * 面试题0503翻转数位
 * <p>
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(11011101111)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * @author zhangzhewen
 * @date 2020/11/2
 */
public class 面试题0503翻转数位 {
    public static void main(String[] args) {
//        System.out.println(new 面试题0503翻转数位().reverseBits(1775));
        System.out.println(new 面试题0503翻转数位().reverseBits(-1));
        System.out.println(3^3^3);
    }

    public int reverseBits(int num) {
        String s = Integer.toBinaryString(num);
        String[] arr = s.split("0");
        if(arr.length<1) {
            return arr.length+1;
        }
        int max = arr[0].length();
        int res = max+1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].length() + arr[i].length() > max) {
                max = arr[i - 1].length() + arr[i].length();
                res = max + 1;
            }
        }
        return res;
    }


    public int reverseBits2(int num) {
        if(num==-1){
            return 32;
        }
        char[] aux = Integer.toBinaryString(num).toCharArray();
        System.out.println(aux);
        // 增加一个最大位，为了设置1后计算最大1的子串
        char[] charArray = new char[aux.length + 1];
        charArray[0] = '0';
        for (int i = 1; i < charArray.length; i++) {
            charArray[i] = aux[i - 1];
        }
        // 回溯计算最大1子串
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                charArray[i] = '1';
                int count = 0;
                for (int j = 0; j < charArray.length; j++) {
                    if (charArray[j] == '1') {
                        count++;
                    }
                    max = Math.max(max, count);
                    if (j < charArray.length - 1 && charArray[j + 1] == '0') {
                        count = 0;
                    }
                }
                charArray[i] = '0';
            }
        }
        return max;
    }
}
