package leetcode.dp;

/**
 *
 * @author Franco
 */
public class HouseRobber {

    private int ans = 0;

    private int rob(int [] nums, int l, int r) {
        int include = 0, exclude = 0;
        for(int j = l;j <= r; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            e = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
