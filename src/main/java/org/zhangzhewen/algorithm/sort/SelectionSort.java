package org.zhangzhewen.algorithm.sort;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/1/14
 */
public class SelectionSort extends Sortable{


    @Override
    public int[] sort(int[] a) {

        int length = a.length;
        for(int i = 0 ; i < length - 1 ; i ++){
            int min = i;
            for(int j = i + 1; j <length ; j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            if(i!=min){
                int tmp = a[min];
                a[min] = a[i];
                a[i] = tmp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        new SelectionSort().print();
    }


}
