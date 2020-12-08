package org.zhangzhewen.algorithm.string;

public class 二进制求和67 {

    public static void main(String[] args) {
        new 二进制求和67().addBinary("0", "0");
    }


    public String addBinary(String a, String b) {
        int n = Math.max(a.length(),b.length()),carry=0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i < n;i++){
            carry += i<a.length()?a.charAt(a.length()-1-i)-'0':0;
            carry += i<b.length()?b.charAt(b.length()-1-i)-'0':0;
            ans.append(carry&1);
            carry >>= 1;
        }
        if(carry>0){
            ans.append(1);
        }
        ans.reverse();
        return ans.toString();
    }
}
