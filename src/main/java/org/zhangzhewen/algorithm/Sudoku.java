package org.zhangzhewen.algorithm;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/30
 */
public class Sudoku {
    public static void main(String[] args) {
        char[][] a = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(a);
        System.out.println(a);
    }


    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {//check row
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {//check column
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {//check 3*3 block
                return false;
            }
        }
        return true;
    }


    /**
     * 验证当前是否遵守数独规则
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        if (length == 0)
            return true;

        for (int i = 0; i < length; i++) {
            boolean[] row_numbers = new boolean[10];
            boolean[] column_numbers = new boolean[10];
            for (int j = 0; j < length; j++) {
                //check if rows are valid
                if (board[i][j] != '.') {
                    if (row_numbers[board[i][j] - '0'])
                        return false;
                    row_numbers[board[i][j] - '0'] = true;
                }

                //check if colums are valid
                if (board[j][i] != '.') {
                    if (column_numbers[board[j][i] - '0'])
                        return false;
                    column_numbers[board[j][i] - '0'] = true;
                }
            }
        }

        //check if every 3*3 grid is valid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] numbers = new boolean[10];
                for (int row = 3 * i; row < 3 * i + 3; row++) {
                    for (int column = 3 * j; column < 3 * j + 3; column++) {
                        if (board[row][column] != '.') {
                            if (numbers[board[row][column] - '0'])
                                return false;
                            numbers[board[row][column] - '0'] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
