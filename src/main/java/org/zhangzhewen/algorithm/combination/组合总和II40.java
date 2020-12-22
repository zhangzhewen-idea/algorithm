package org.zhangzhewen.algorithm.combination;

import java.util.*;
import java.util.stream.Collectors;

public class 组合总和II40 {

    public static void main(String[] args) {
        new 组合总和II40().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<int[]> freq = new ArrayList();


        List<List<Integer>> res = new ArrayList();
        Set<String> aux = new HashSet();
        dfs(aux, candidates, target, 0, new ArrayList());
        return res;
    }

    void dfs(Set<String> res, int[] candidates, int target, int start, List<Integer> sub) {

        if (target == 0) {
            Collections.sort(sub);
            res.add(sub.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
            return;
        }
        if (start == candidates.length) {
            return;
        }
        dfs(res, candidates, target, start + 1, sub);
        sub.add(candidates[start]);
        dfs(res, candidates, target - candidates[start], start + 1, sub);
        sub.remove(sub.size() - 1);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        List<int[]> freq = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int size = freq.size();
            if (size == 0 || freq.get(size - 1)[0] != candidates[i]) {
                freq.add(new int[]{candidates[i], 1});
            } else {
                freq.get(size - 1)[1]++;
            }
        }
        dfs2(res, freq, target, 0, sequence);

        return res;
    }

    void dfs2(List<List<Integer>> res, List<int[]> freq, int target, int start, List<Integer> sequence) {

        System.out.println();
        for(int i : sequence){
            System.out.print(i + " ");
        }

        if (target == 0) {
            res.add(new ArrayList(sequence));
            return;
        }
        if (start == freq.size() || target < freq.get(start)[0]) {
            return;
        }
        dfs2(res,freq,target,start+1,sequence);
        int most = Math.min(target / freq.get(start)[0], freq.get(start)[1]);
        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(start)[0]);
            dfs2(res, freq, target - i * freq.get(start)[0], start + 1, sequence);
        }
        for (int i = 1; i <= most; i++) {
            sequence.remove(sequence.size() - 1);
        }

    }

}
