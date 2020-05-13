package org.zhangzhewen.algorithm.union_find;

/**
 * NumIslands
 * https://leetcode-cn.com/problems/friend-circles/submissions/
 * https://time.geekbang.org/course/detail/130-72535
 *
 * @author zhangzhewen
 * @date 2020/5/12
 */
public class FindCircleNum {

    public static void main(String[] args) {

        int[][] grid = new int[][]
                {
                        {1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 0, 1, 1}
                };

        System.out.println(new FindCircleNum().findCircleNum(grid));

    }

    public int findCircleNum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < unionFind.getRow(); i++) {
            for (int j = 0; j < unionFind.getCol(); j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < directions.length; k++) {
                        int rowDirection = i + directions[k][0];
                        int colDirection = j + directions[k][1];
                        if (rowDirection >= 0 && rowDirection < unionFind.getRow()
                                && colDirection >= 0 && colDirection < unionFind.getCol()
                                && grid[rowDirection][colDirection] == 1) {
                            unionFind.union(i * unionFind.getCol() + j, rowDirection * unionFind.getCol() + colDirection);
                        }
                    }
                }
            }
        }

        return unionFind.getCount();
    }

    private class UnionFind {
        private int[] roots;
        private final int row, col;
        private int count = 0;

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getCount() {
            return count;
        }

        public UnionFind(int[][] grid) {
            row = grid.length;
            col = grid[0].length;
            roots = new int[row * col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        roots[i * col + j] = i * col + j;
                        count++;
                    } else {
                        roots[i * col + j] = -1;
                    }
                }
            }
        }

        private int findRoot(int i) {
            int root = i;
            while (root != roots[root]) {
                root = roots[root];
            }
            int tmp;
            while (i != roots[i]) {
                tmp = roots[i];
                roots[i] = root;
                i = tmp;
            }
            return root;
        }

        public void union(int p, int q) {
            if (p != q) {
                int pRoot = findRoot(p);
                int qRoot = findRoot(q);

                if (pRoot != qRoot) {
                    roots[pRoot] = qRoot;
                    count--;
                }
            }
        }
    }
}
