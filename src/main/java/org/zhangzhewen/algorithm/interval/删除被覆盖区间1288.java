package org.zhangzhewen.algorithm.interval;

import java.util.*;

/*
给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。

只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。

在完成所有删除操作后，请你返回列表中剩余区间的数目。

 

示例：

输入：intervals = [[1,4],[3,6],[2,8]]
输出：2
解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 

提示：​​​​​​

1 <= intervals.length <= 1000
0 <= intervals[i][0] < intervals[i][1] <= 10^5
对于所有的 i != j：intervals[i] != intervals[j]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-covered-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除被覆盖区间1288 {

    public static void main(String[] args) {
        new 删除被覆盖区间1288().findContinuousSequence(9);
    }

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> ans = new ArrayList();
        for(int i=1;i<= target/2+1;i++){
            List<Integer> l = new ArrayList();
            int sum = 0;
            for(int j = i;j<=target/2+1;j++){
                sum += j;
                if(sum>target){
                    break;
                }else if(sum==target){
                    l.add(j);
                    ans.add(l);
                    break;
                }
                l.add(j);
            }
        }
        
        int[][] res = new int[ans.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i).stream().mapToInt(Integer::intValue).toArray();
        }

        return res;
    }


}
