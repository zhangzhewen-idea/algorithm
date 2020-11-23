package org.zhangzhewen.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 杨辉三角II119 {
    public static void main(String[] args) {

    }
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0){
            return new ArrayList();
        }
        Integer[] row = new Integer[rowIndex];
        row[0]=1;
        for(int i = 1 ; i < rowIndex; i ++){
            for(int j = 1;j < i;j++){
                row[j] = row[j]+row[j-1];
            }
            row[i]=1;
        }
        return Arrays.asList(row);
    }
}
