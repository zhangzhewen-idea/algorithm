package org.zhangzhewen.algorithm.dynamic_programming;

/**
 * 判断子序列392
 *
 * @author zhangzhewen
 * @date 2020/10/13
 */
public class 判断子序列392 {

    public static void main(String[] args) {
        new 判断子序列392().isSubsequence("abc","ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        // 先预处理
        int[][] dp = new int[t.length()+1][26];
        for(int i = 0 ; i < 26;i++){
            dp[t.length()][i] = -1;
        }
        for(int i = t.length()-1;i>=0;i--){
            int j = 0;
            while(j<26){
                dp[i][j]=dp[i+1][j];
                j++;
            }
            dp[i][t.charAt(i)-'a']=i+1;
        }

        // 匹配
        int nextIndex = dp[0][s.charAt(0)-'a'];
        for(int i = 1 ; i < s.length();i++ ){
            if(nextIndex==-1){
                return false;
            }
            nextIndex = dp[nextIndex][s.charAt(i)-'a'];
        }
        if(nextIndex==-1){
            return false;
        }

        return true;
    }

    /*

    public boolean isSubsequence(String s, String t) {
        int tIdx=0,sIdx=0;
        while(sIdx<s.length()&&tIdx<t.length()){
            if(s.charAt(tIdx)==t.charAt(sIdx)){
                tIdx++;
                sIdx++;
            }else{
                tIdx++;
            }
        }
        return s.length()==sIdx;
    }*/

}
