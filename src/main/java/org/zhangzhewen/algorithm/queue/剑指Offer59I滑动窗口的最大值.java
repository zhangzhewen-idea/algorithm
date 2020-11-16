package org.zhangzhewen.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 剑指Offer59I滑动窗口的最大值 {

    public static void main(String[] args) {

        new 剑指Offer59I滑动窗口的最大值().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && queue.getFirst() <= (i - k)) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                res.add(nums[queue.getFirst()]);
            }
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

}
