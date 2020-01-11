package org.zhangzhewen.algorithm.static_search;

/**
 * 插值查找
 *
 * @author zhangzhewen
 * @date 2019/5/28
 */
public class InsertValueSearch extends Base {

    protected int search2(int[] a, int n) {
        return search(a,n,0,a.length-1);
    }

    int search2(int[] a,double key,int left,int right){
        while(left<right){
            int middle = (int)(left + (right - left)*((key-a[left])/(a[right]-a[left])));
            if(a[middle]==key){
                return middle;
            }else if(key<a[middle]){
                right = middle-1;
            }else{
                left=middle+1;
            }
        }
        return -1;
    }

    protected int search(int[] a, int n) {
        return search(a,n,0,a.length-1);
    }

    int search(int[] a,double key,int left,int right){

        return -1;
    }

















    public static void main(String[] args) {
        new InsertValueSearch().run();
    }
}
