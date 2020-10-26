package org.zhangzhewen.algorithm.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 柠檬水找零860
 *
 * @author zhangzhewen
 * @date 2020/10/26
 */
public class 柠檬水找零860 {
    public static void main(String[] args) {
        new 柠檬水找零860().lemonadeChange(new int[]{5, 5, 5, 10, 5, 20, 5, 10, 5, 20});
        /*List<Integer> f = new ArrayList(){{
            add(5);
        }};
        new 柠檬水找零860().add(f,10);
        new 柠檬水找零860().add(f,15);
        new 柠檬水找零860().add(f,25);
        System.out.println();
        Iterator<Integer> ite = f.iterator();
        System.out.println();*/
    }

    public boolean lemonadeChange(int[] bills) {
        List<Integer> takeAmountList = new ArrayList();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                add(takeAmountList,bills[i]);
                continue;
            }
            Iterator<Integer> ite = takeAmountList.iterator();
            int aux = bills[i];
            while (ite.hasNext()) {
                int takeAmount = ite.next();
                if (aux > takeAmount) {
                    aux -= takeAmount;
                    ite.remove();
                }
            }
            if (aux == 5) {
                add(takeAmountList,bills[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    public void add(List<Integer> takeAmountList, int e) {
        ListIterator<Integer> ite = takeAmountList.listIterator();
        while (ite.hasNext()) {
            if(e > ite.next()){
                ite.previous();
                break;
            }
        }
        ite.add(e);
    }
}
