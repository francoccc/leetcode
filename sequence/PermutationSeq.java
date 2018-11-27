package leetcode.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franco
 */
public class PermutationSeq {

    List<Integer> nums = new ArrayList<>();

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int interval = 1;
        k--;
        for(int i = 1; i <= n; i++) {
            nums.add(i);
            interval *= i;
        }

        int t = n;

        while(nums.size() != 1) {
            interval /= t--;
            int i = k / interval;
            k -= i * interval;
            sb.append(Integer.toString(nums.get(i)));
            nums.remove(i);
        }
        sb.append(nums.get(0));
        return sb.toString();
    }
}
