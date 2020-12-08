package org.zhangzhewen.algorithm.two_pointers;

public class 验证回文串125 {
    public static void main(String[] args) {
        new 验证回文串125().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l =0,h=s.length()-1;
        while(l<h){
            while(l<h&&!Character.isLetterOrDigit(chars[l])){
                l++;
            }
            while(l<h&&!Character.isLetterOrDigit(chars[h])){
                h--;
            }
            if(l<h&&Character.toLowerCase(chars[l])!=Character.toLowerCase(chars[h])){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}
