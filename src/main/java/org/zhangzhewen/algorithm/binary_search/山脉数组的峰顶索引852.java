package org.zhangzhewen.algorithm.binary_search;

public class 山脉数组的峰顶索引852 {

    public static void main(String[] args) {
        new 山脉数组的峰顶索引852().peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0});
    }

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            if ((mid + 1 < arr.length && arr[mid] > arr[mid + 1])
                    && (mid - 1 >= 0 && arr[mid] > arr[mid - 1])
            ) {
                return mid;
            } else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1]) {
                h = mid - 1;
            } else if (mid - 1 >= 0 && arr[mid] > arr[mid - 1]) {
                l = mid + 1;
            }
        }
        return -1;
    }

}
