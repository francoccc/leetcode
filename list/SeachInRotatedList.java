package leetcode.list;

public class SeachInRotatedList {

    private int biSearch(int[] nums, int target, int l, int r) {
        if(nums[l] > target || nums[r] < target) {
            return -1;
        }
        int m = (l + r) / 2;
        int lt = -1,rt = -1;
        int t = -1;
        if(nums[m] == target) {
            return m;
        }
        else if(nums[m] < target) {
            lt = biSearch(nums, target, m + 1, r);
        }
        else if(nums[m] > target) {
            rt = biSearch(nums, target, l, m);
        }
        if(lt != -1) t = lt;
        if(rt != -1) t = rt;
        return t;
    }

    private int split(int[] nums, int target, int l, int r) {
        int m = (l + r) / 2;
        int lt, rt;
        int t = -1;
        if(nums[l] < nums[m]) lt = biSearch(nums, target, l, m);
        else lt = split(nums, target, l, m);
        if(nums[m + 1] < nums[r]) rt = biSearch(nums, target, m + 1, r);
        else rt = split(nums, target, l, m);
        if(lt != -1) t = lt;
        if(rt != -1) t = rt;
        return t;
    }

    public int search(int[] nums, int target) {
        return split(nums, target, 0, nums.length - 1);
    }
}
