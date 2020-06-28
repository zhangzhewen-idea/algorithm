package org.zhangzhewen.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Hanota
 *
 * @author zhangzhewen
 * @date 2020/6/28
 */
public class Hanota {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>() {{
            add(3);
            add(2);
            add(1);
        }};
        List<Integer> b = new ArrayList<Integer>() {{
        }};
        List<Integer> c = new ArrayList<Integer>() {{
        }};
        new Hanota().hanota(a, b, c);
        System.out.println();
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanoi(A.size(), A, B, C);
    }

    public void hanoi(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
        } else {
            //把A经过辅助C放到B上
            hanoi(n - 1, A, C, B);
            //把A放到C上
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
            //把B经过辅助A放到C上
            hanoi(n - 1, B, A, C);
        }
    }

}
