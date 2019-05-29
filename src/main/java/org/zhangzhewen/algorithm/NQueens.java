package org.zhangzhewen.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/28
 */
public class NQueens {
    public static void main(String[] args) {
        solveNQueens(4);
        totalNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        recursion(0,new boolean[n],new boolean[2*n],new boolean[2*n],new String[n],res);
        return res;
    }

    private static void recursion(int rowNum,boolean[] attackCols,boolean[] attackPIEs,boolean[] attackNAs,String[] board,List<List<String>> result){
        if(rowNum==board.length){
            result.add(Arrays.asList(board.clone()));
            return;
        }

        for (int colNum = 0; colNum < board.length; colNum++) {
            int attackPIE = colNum+rowNum;
            int attackNA = colNum-rowNum+board.length;
            if(attackCols[colNum]||attackPIEs[attackPIE]||attackNAs[attackNA]){
                continue;
            }
            attackCols[colNum]=true;
            attackPIEs[attackPIE]=true;
            attackNAs[attackNA]=true;
            char[] rowCharArr = new char[board.length];
            Arrays.fill(rowCharArr,'.');
            rowCharArr[colNum] = 'Q';
            board[rowNum] = new String(rowCharArr);
            recursion(rowNum+1,attackCols,attackPIEs,attackNAs,board,result);
            attackCols[colNum]=false;
            attackPIEs[attackPIE]=false;
            attackNAs[attackNA]=false;
        }
    }

    /*public static List<List<String>> solveNQueens(int n){
        List<List<String>> totalNQueensResult = new ArrayList<>();
        helper(0,new boolean[n],new boolean[2*n],new boolean[2*n],new String[n],totalNQueensResult);
        return totalNQueensResult;
    }

    private static void helper(int r,boolean [] cols,boolean[] d1,boolean[] d2,String[] board,List<List<String>> totalNQueensResult){
        if(r==board.length){
            totalNQueensResult.add(Arrays.asList(board.clone()));
        }
        else{
            for(int c= 0;c<board.length;c++){
                int id1 = r-c+board.length,id2=2*board.length-r-c-1;
                if(!cols[c]&&!d1[id1]&&!d2[id2]){
                    char[] row = new char[board.length];
                    Arrays.fill(row,'.');
                    row[c] = 'Q';
                    board[r] = new String(row);
                    cols[c] = true;d1[id1]=true;d2[id2]=true;
                    helper(r+1,cols,d1,d2,board,totalNQueensResult);
                    cols[c]=false;d1[id1]=false;d2[id2]=false;
                }
            }
        }
    }*/


    static Integer totalNQueensResult = 0;
    public static int totalNQueens(int n) {
        recursion(0,new boolean[n],new boolean[2*n],new boolean[2*n],n);
        return totalNQueensResult;
    }

    private static void recursion(int rowNum,boolean[] attackCols,boolean[] attackPIEs,boolean[] attackNAs,final int n){
        if(rowNum==n){
            totalNQueensResult++;
            return;
        }

        for (int colNum = 0; colNum < n; colNum++) {
            int attackPIE = colNum+rowNum;
            int attackNA = colNum-rowNum+n;
            if(attackCols[colNum]||attackPIEs[attackPIE]||attackNAs[attackNA]){
                continue;
            }
            attackCols[colNum]=true;
            attackPIEs[attackPIE]=true;
            attackNAs[attackNA]=true;
            recursion(rowNum+1,attackCols,attackPIEs,attackNAs,n);
            attackCols[colNum]=false;
            attackPIEs[attackPIE]=false;
            attackNAs[attackNA]=false;
        }
    }
}
