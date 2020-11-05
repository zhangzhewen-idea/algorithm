package org.zhangzhewen.algorithm.union_find;

import java.util.HashSet;
import java.util.Set;

/**
 * 朋友圈547
 * <p>
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出：2
 * 解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出：1
 * 解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 *
 * @author zhangzhewen
 * @date 2020/11/3
 */
public class 朋友圈547 {

    public static void main(String[] args) {
        int res = new 朋友圈547().findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        });
        System.out.println(res);
    }

    public int findCircleNum(int[][] M) {
        UnionFind u = new UnionFind(M);
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < u.row; i++) {
            for (int j = 0; j < u.col; j++) {
                if (M[i][j] == 1) {
                    for (int k = 0; k < dir.length; k++) {
                        if (dir[k][0] + i >= 0 && dir[k][0] + i < u.col && dir[k][1] + j >= 0 && dir[k][1] + j < u.row && M[dir[k][0] + i][dir[k][1] + j] == 1) {
                            u.union(i, j, dir[k][0] + i, dir[k][1] + j);
                        }
                    }
                }
            }
        }
        return u.calcCount();
    }

    static class UnionFind {
        int[] data;
        int row, col, size, count;

        public UnionFind(int[][] m) {
            row = m.length;
            col = m[0].length;
            data = new int[row * col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (m[i][j] == 1) {
                        data[i * col + j] = i * col + j;
                    } else {
                        data[i * col + j] = -1;
                    }
                }
            }
            size = row * col;
        }

        public int findRoot(int root) {
            int origin = root;
            while (root != data[root]) {
                root = data[root];
            }
            // 压缩路劲
            while (origin != root) {
                int aux = data[origin];
                data[origin] = root;
                origin = aux;
            }
            return root;
        }

        public int findRoot(int r, int c) {
            return findRoot(r * col + c);
        }

        public void union(int ar, int ac, int br, int bc) {
            int rootA = findRoot(ar, ac);
            int rootB = findRoot(br, bc);
            if (rootA != rootB) {
                data[rootA] = rootB;
            }
        }

        public int calcCount() {
            Set<Integer> countSet = new HashSet();
            for (int i = 0; i < data.length; i++) {
                if (data[i] != -1 && data[i] != i) {
                    countSet.add(findRoot(data[i]));
                }
            }
            count = countSet.size();
            return count;
        }
    }

}
