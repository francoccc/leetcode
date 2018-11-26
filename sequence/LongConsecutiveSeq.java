package leetcode.sequence;

import java.util.HashSet;

public class LongConsecutiveSeq {

    private int ans = 1;
    private HashSet<Integer> bucket = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 0, min = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        for(int i = 0; i < nums.length; i++) {
            bucket.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(bucket.contains(nums[i])) {
                bucket.remove(nums[i]);
                int li = nums[i] - min, ri = nums[i] - min;
                while(bucket.contains(li)) {
                    bucket.remove(li--);
                }
                while(bucket.contains(ri)) {
                    bucket.remove(ri++);
                }
                ans = Math.max(ans,ri - li - 1);
            }
        }
        return ans;
    }
}
