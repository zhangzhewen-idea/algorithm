package org.zhangzhewen.algorithm.leetcode;

/**
 * f
 *
 * @author zhangzhewen
 * @date 2020/10/10
 */
public class 被围绕的区域130 {

    public static void main(String[] args) {
        new 被围绕的区域130().solve(
                new char[][]{
                        {'O','X','X','O','X'},
                        {'X','O','O','X','O'},
                        {'X','O','X','O','X'},
                        {'O','X','O','O','O'},
                        {'X','X','O','X','O'}
                }
        );
        new 被围绕的区域130().canMakeArithmeticProgression(new int[]{4,3,2,1});
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        for(int i = arr.length/2 ; i >=0 ;i--){
            heapify(arr,i,arr.length-1);
        }
        for(int i = arr.length-1;i>0;i--){
            int aux = arr[i];
            arr[i] = arr[0];
            arr[0] = aux;

            heapify(arr,0,i-1);
        }

        System.out.println();
        return true;

    }
    void heapify(int[] arr,int i,int len){
        int l = i*2+1;
        int r = i*2+2;
        int max = i;
        if(l<=len&&arr[l]>arr[max]){
            max = l;
        }
        if(r<=len&&arr[r]>arr[max]){
            max = r;
        }
        if(max!=i){
            int aux = arr[max];
            arr[max]=arr[i];
            arr[i]=aux;
            heapify(arr,max,len);
        }
    }

    int n, m;

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

}
