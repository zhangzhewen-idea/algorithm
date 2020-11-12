package org.zhangzhewen.algorithm.binary_indexed_trees;
/*
线段树详解：https://leetcode-cn.com/problems/range-sum-query-mutable/solution/qu-yu-he-jian-suo-shu-zu-ke-xiu-gai-by-leetcode/
 */
public class 区域和检索_数组可修改307 {
    public static void main(String[] args) {
        NumArray n = new NumArray(new int[]{1, 3, 5});
        System.out.println(n.sumRange(0,2));
        n.update(1,2);
        System.out.println(n.sumRange(0,2));


//        NumArray n = new NumArray(new int[]{1, 2, 3,4,5});
    }

    static class NumArray {
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            if(nums.length>0){
                n = nums.length;
                tree = new int[n*2];
                buildTree(nums);
            }
        }
        private void buildTree(int[] nums){
            for (int i = n,j=0; i < 2*n; i++,j++) {
                tree[i] = nums[j];
            }
            for (int i = n-1; i > 0; i--) {
                tree[i] = tree[i*2]+tree[i*2+1];
            }
        }

        public void update(int i, int val) {
            int pos = i+n;
            tree[pos] = val;
            while(pos>0){
                int right = pos;
                int left = pos;
                if( (pos&1)==1 ){
                    left -= 1;
                }else{
                    right += 1;
                }
                tree[pos/2] = tree[left]+tree[right];
                pos = pos/2;
            }
        }

        public int sumRange(int i, int j) {
            int left = i+n;
            int right = j+n;
            int sum=0;
            while(left<=right){
                if((left&1)==1){
                    sum += tree[left];
                    left++;
                }
                if((right&1)==0){
                    sum += tree[right];
                    right--;
                }
                left/=2;
                right/=2;
            }
            return sum;
        }
    }




}
