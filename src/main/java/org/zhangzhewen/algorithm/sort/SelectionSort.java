package org.zhangzhewen.algorithm.sort;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/1/14
 */
public class SelectionSort extends Sortable{


    public int[] sort1(int[] a) {

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





    public int[] sort(int[] a){

        for (int i = 0; i < a.length; i++) {
            int minIndex=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[minIndex]>a[j]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                int tmp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = tmp;
            }
        }

        return a;
    }








    public static void main(String[] args) {
        new SelectionSort().print();
    }


}
