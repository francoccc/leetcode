package leetcode.list;

public class FindKNum {

    private void mergeSort(int[] nums, int[] t, int l, int r) {
        if(l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(nums, t, l, m);
        mergeSort(nums, t, m + 1, r);
        int i = l, j = m, k = l;
        while(i <= m && j <= r) {
            if(nums[i] > nums[j]) {
                t[k++] = nums[i++];
            }
            else {
                t[k++] = nums[j++];
            }
        }
        while(k <= r) {
            if(i <= m) {
                t[k++] = nums[i++];
            }
            else {
                t[k++] = nums[j++];
            }
        }
        for(k = l; k <= r; k++) {
            nums[k] = t[k];
        }
    }

    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return nums[k - 1];
    }
}
