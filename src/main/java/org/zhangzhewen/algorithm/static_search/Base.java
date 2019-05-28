package org.zhangzhewen.algorithm.static_search;

/**
 * 总结： 平均性能平均性能：斐波那契>折半>插值
 *
 * 因为折半查找进行加法与除法运算（mid = low + (high - low) / 2）,插值查找进行复杂的四则运算( mid = low + (key - a[low] / (a[high] - a[low]) * (high - low)) )，
 * 而斐波那契查找只是运用简单加减法运算 (mid = low + f[k-1] -1) ，在海量的数据查找过程中，这种席位的差别会影响最终的查找效率。
 * 三种有序表的查找本质上是分割点的选择不同，各有优劣，实际开发可根据数据的特点综合考虑再做决定。
 * http://blog.jobbole.com/73517/
 * @author zhangzhewen
 * @date 2019/5/28
 */
public abstract class Base {
    abstract protected int search(int[] a,int n);

    protected void run(){
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        int n = 3;

        System.out.println("{1,2,3,4,5,6,7,8,9},target:"+n+",result:"+ search(a,n));
    }
}
