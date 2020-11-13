package org.zhangzhewen.algorithm.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 面试题1611跳水板 {
    public static void main(String[] args) {
        int[] res = new 面试题1611跳水板().divingBoard(1, 2, 3);
        System.out.println(res);
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }


}
