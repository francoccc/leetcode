package leetcode.combination;

import java.util.*;

public class Combination39 {

    private List<List<Integer>> ans = new ArrayList<>();
    private int[] candidates;
    private int target;

    private void backTrace(int t, int offset, List<Integer> res) {
        if(t > target) return;
        if(t == target) {
            ArrayList<Integer> tres = new ArrayList<>(res);
            ans.add(tres);
            return;
        }
        for(int i = offset; i < candidates.length; i++) {
            Integer num = new Integer(candidates[i]);
            res.add(num);
            backTrace(t + candidates[i], i, res);
            res.remove(num);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backTrace(0, 0, new ArrayList<>());
        return ans;
    }
}
