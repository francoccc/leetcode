package leetcode.combination;

import java.util.ArrayList;
import java.util.List;

public class Combination40 {

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
            backTrace(t + candidates[i], i + 1, res);
            res.remove(num);
            while(i < candidates.length - 1
                    && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

    private void mSort(int[] a, int[] t, int l, int r) {
        if(l == r)
            return;
        int m = (l + r) / 2;
        mSort(a, t, l, m);
        mSort(a, t, m + 1, r);
        int i = l, j = m + 1, k = l;
        while(i <= m && j <= r) {
            if(a[i] < a[j])
                t[k++] = a[i++];
            else
                t[k++] = a[j++];
        }
        while(k <= r) {
            t[k++] = i <= m ? a[i++] : a[j++];
        }
        for(k = l; k <= r; k++) {
            a[k] = t[k];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        mSort(candidates, new int[candidates.length], 0, candidates.length - 1);
        this.candidates = candidates;
        //Arrays.sort(candidates);
        backTrace(0, 0, new ArrayList<>());
        return ans;
    }
}

