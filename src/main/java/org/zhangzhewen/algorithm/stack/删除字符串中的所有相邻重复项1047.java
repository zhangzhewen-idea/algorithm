package org.zhangzhewen.algorithm.stack;

/**
 * 删除字符串中的所有相邻重复项1047
 *
 * @author zhangzhewen
 * @date 2020/10/27
 */
public class 删除字符串中的所有相邻重复项1047 {
    public static void main(String[] args) {

    }
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(sb.length()!=0 && sb.charAt(sb.length()-1)==c){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
