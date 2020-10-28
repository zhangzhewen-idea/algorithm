package org.zhangzhewen.algorithm.stack;

/**
 * 整理字符串1544
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 整理字符串1544 {
    public static void main(String[] args) {
        System.out.println('a' - 'A');
    }

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && Math.abs(sb.charAt(sb.length() - 1) - c) == 32) {
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
