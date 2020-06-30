package org.zhangzhewen.algorithm;

/**
 * FindMedianSortedArrays
 *
 * @author zhangzhewen
 * @date 2020/6/30
 */
public class FindMedianSortedArrays {

    /**
     * 切分法
     * 主体函数是根据两个字符串长度的总和判断如何调用递归函数以及返回结果。
     * - 当总长度为奇数时，返回正中间的数
     * - 当总长度为偶数时，返回中间两个数的平均值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int k = (m + n) / 2;

        // 奇数情况，选取中间一个数字 - f(k+1)
        if ((m + n) % 2 == 1) {
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, k + 1);
        }
        // 偶数情况，选取中间两个数字，然后除以二 - (f(k)+f(k+1)) / 2
        else {
            return (
                    findKth(nums1, 0, m - 1, nums2, 0, n - 1, k) +
                            findKth(nums1, 0, m - 1, nums2, 0, n - 1, k + 1)
            ) / 2.0;
        }
    }


    /**
     * 寻找第K小的数字。
     *
     * @param nums1 原数组1
     * @param l1    原数组1 的 左侧低位
     * @param h1    原数组1 的 左侧高位
     * @param nums2 原数组2
     * @param l2    原数组2 的 右侧低位
     * @param h2    原数组2 的 右侧高位
     * @param k     目标数字k
     * @return
     */
    double findKth(int[] nums1, int l1, int h1, int[] nums2, int l2, int h2, int k) {

        // 原数组1 的 要计算的个数
        int m = h1 - l1 + 1;
        // 原数组2 的 要计算的个数
        int n = h2 - l2 + 1;

        // 如果nums1数组的长度大于nums2数组的长度，将二者互换，加快程序结束
        if (m > n) {
            return findKth(nums2, l2, h2, nums1, l1, h1, k);
        }

        // 如果nums1数组的长度为0时，直接返回nums2数组里第k小的数
        if (m == 0) {
            return nums2[l2 + k - 1];
        }

        // k等于1，返回两个数组中的最小值
        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }

        // 分别选两个数组的中间数
        int na = Math.min(k / 2, m);
        int nb = k - na;
        int va = nums1[l1 + na - 1];
        int vb = nums2[l2 + nb - 1];

        // 比较两者的大小
        // - 如果相等，表明中位数已找到，返回该值
        // - 如果不等，进行剪枝处理
        if (va == vb) {
            return va;
        } else if (va < vb) {
            return findKth(nums1, l1 + na, h1, nums2, l2, l2 + nb - 1, k - na);
        } else {
            return findKth(nums1, l1, l1 + na - 1, nums2, l2 + nb, h2, k - nb);
        }
    }


}
