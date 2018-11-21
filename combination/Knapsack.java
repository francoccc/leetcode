package leetcode.combination;

import java.util.*;

class Knapsack {

    private static HashMap<Integer, Result> map = new HashMap<>();

    class Result {
        int[] num;
        Result next;
        Result last;

        Result() {
            num = new int[1];
        }
    }

    private void addNums(Result temp, int a, Result old, int count) {
        int offset = old.num.length - 1;
        for(int i = 1; i <= offset; i++) {
            temp.num[i] = old.num[i];
        }
        for (int i = 1; i <= count; i++) {
            temp.num[i + offset] = a;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        map.put(0, new Result());
        for(int i = 0; i < candidates.length; i++) {
            for(int j = 1; candidates[i]*j <= target; j *= 2) {
                Set<Integer> sets = new HashSet<>(map.keySet());
                for(Integer t : sets) {
                    Result res = map.get(t);
                    if(t  + candidates[i]*j > target) continue;
                    Result tres = new Result();
                    tres.num = new int[res.num.length + j];
                    addNums(tres, candidates[i], res, j);
                    if(null == map.get(t  + candidates[i]*j)) {
                        tres.last = tres;
                        map.put(t  + candidates[i]*j, tres);
                    }
                    else {
                        map.get(t  + candidates[i]*j).last.next = tres;
                        map.get(t  + candidates[i]*j).last = tres;
                    }
                }
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        Result res = map.get(target);
        while(null != res) {
            List<Integer> array = new ArrayList<>();
            for(int i = 1; i < res.num.length; i++) {
                array.add(res.num[i]);
            }
            answer.add(array);
            res = res.next;
        }
        return answer;
    }
}
