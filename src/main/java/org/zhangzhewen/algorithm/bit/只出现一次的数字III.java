package org.zhangzhewen.algorithm.bit;

public class 只出现一次的数字III {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }

    public int[] singleNumber2(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        diff = Integer.highestOneBit(diff);
        int[] result = { 0, 0 };
        for (int n : nums) {
            //当前位是 0 的组, 然后组内异或
            if ((diff & n) == 0) {
                result[0] ^= n;
                //当前位是 1 的组
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }

    public int[] singleNumber3(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        int diff2 = Integer.highestOneBit(diff);
        int[] result = { 0, 0 };
        for (int n : nums) {
            //当前位是 0 的组, 然后组内异或
            if ((diff2 & n) == 0) {
                result[0] ^= n;
            }
        }
        result[1] = diff ^ result[0];
        return result;
    }
}
