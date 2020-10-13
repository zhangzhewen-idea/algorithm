package org.zhangzhewen.algorithm.sort;

/**
 * 按奇偶排序数组II922
 *
 * @author zhangzhewen
 * @date 2020/10/12
 */
public class 按奇偶排序数组II922 {

    public static void main(String[] args) {
//        new 按奇偶排序数组II922().sortArrayByParityII(new int[]{4,2,5,7});
        new 按奇偶排序数组II922().sortArrayByParityII(new int[]{4,1,2,3});
    }

    public int[] sortArrayByParityII(int[] a) {
        if(a==null || a.length==1){
            return a;
        }
        int odd = 1;
        for(int even = 0;even<a.length;even+=2){
            if( (a[even]&1)==1 ){
                while( (a[odd]&1)==1 ){
                    odd+=2;
                }
                swap(a,odd,even);
            }
        }
        return a;
    }

    private void swap(int[] a,int i,int j){
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }


}
