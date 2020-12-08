package org.zhangzhewen.algorithm.bit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 重复的DNA序列187 {
    public static void main(String[] args) {
        new 重复的DNA序列187().findRepeatedDnaSequences("AAAAAAAAAAA");
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList();
        Set<String> aux = new HashSet();
        Set<String> aux2 = new HashSet();
        for(int i = 0 ; i <= s.length()-10; i++){
            if(aux.contains(s.substring(i,i+10))){
                aux2.add(s.substring(i,i+10));
            }else{
                aux.add(s.substring(i,i+10));
            }
        }
        for(String v : aux2){
            ans.add(v);
        }
        return ans;
    }
}
