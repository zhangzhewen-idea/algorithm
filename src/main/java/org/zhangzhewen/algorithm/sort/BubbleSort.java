package org.zhangzhewen.algorithm.sort;

public class BubbleSort {

    // 冒泡排序，a 表示数组，n 表示数组大小
    public static int[] bubbleSort(int[] a ) {
        int length = a.length;
        for(int i = 1 ;i < length ; i++){
            boolean noChanged = true;
            for(int j = 0 ; j < length - i ; j++){
                if(a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    noChanged = false;
                }
            }
            if(noChanged){
                break;
            }
        }
        return a;
    }



    public static void main(String[] args) {
        int[] a = bubbleSort(new int[]{10,8, 7, 5 ,3});
        for(int e : a){
            System.out.print(e+" ");
        }
    }


}
