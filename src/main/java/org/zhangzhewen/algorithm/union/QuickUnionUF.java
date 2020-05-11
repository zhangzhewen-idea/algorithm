package org.zhangzhewen.algorithm.union;

/**
 * QuickUnionUF
 *
 * @author zhangzhewen
 * @date 2020/5/12
 */
public class QuickUnionUF {
    public static void main(String[] args) {
        QuickUnionUF u1 = new QuickUnionUF(5);

        u1.union(0,1);
        u1.union(1,2);
        u1.union(2,3);

        System.out.println(u1.findRoot(1));


    }
    private int[] roots;

    public QuickUnionUF(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    private int findRoot(int i) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int qroot = findRoot(q);
        int proot = findRoot(p);
        roots[proot] = qroot;
    }
}
