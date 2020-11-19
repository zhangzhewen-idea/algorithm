package org.zhangzhewen.algorithm.array;

public class 解压缩编码列表1313 {

    public int countNegatives(int[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            c += getNegativeCountByBinarySearch(grid[i]);
        }
        return c;
    }

    int getNegativeCountByBinarySearch(int[] nums) {
        int l = 0, h = nums.length - 1, pos = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < 0) {
                pos = mid;
                h = mid - 1;
            } else if (nums[mid] > 0) {
                l = mid + 1;
            } else {
                break;
            }
        }
        if (pos == -1) {
            return 0;
        }
        return nums.length - pos;
    }

    /* 自己写的，O(mn)
    public int countNegatives(int[][] grid) {
        int c = 0;
        for(int i = 0 ; i < grid.length;i++){
            for(int j = 0 ; j < grid[0].length; j ++){
                if(grid[i][j]<0){
                    c++;
                }
            }
        }
        return c;
    }
    */


}
