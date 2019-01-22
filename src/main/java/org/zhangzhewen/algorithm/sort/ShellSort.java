package org.zhangzhewen.algorithm.sort;

public class ShellSort extends Sortable{

    @Override
    public int[] sort(int[] a) {
        int length = a.length;
        int gap = 1;
        while(gap < length){
            gap = gap * 3 + 1;
        }
        while(gap > 0){
            for(int i = gap ; i < length;i++){
                int tmp = a[i];
                int j = i - gap;
                while(j >= 0 && a[j]>tmp){
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j+gap] = tmp;
            }
            gap = (int)Math.floor(gap / 3);
        }
        return a;
    }



    public static void main(String[] args) {
        new ShellSort().print();
    }


}
