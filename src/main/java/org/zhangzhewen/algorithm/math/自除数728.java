package org.zhangzhewen.algorithm.math;

import java.util.ArrayList;
import java.util.List;

public class 自除数728 {

    public static void main(String[] args) {
        new 自除数728().selfDividingNumbers(1, 22);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int i = left; i <= right; i++) {
            int aux = i;
            boolean isSelfDividingNumber = true;
            while (aux > 0) {
                if ((aux % 10)==0 || (i % (aux % 10)) != 0) {
                    isSelfDividingNumber = false;
                    break;
                }
                aux /= 10;
            }
            if (isSelfDividingNumber) {
                ans.add(i);
            }
        }
        return ans;
    }
}
