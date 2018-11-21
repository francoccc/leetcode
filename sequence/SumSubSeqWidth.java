package leetcode.sequence;

import java.util.Arrays;

/**
 *
 * @author franco
 * math problem
 * O(n^2)
 */
public class SumSubSeqWidth {

    private final static int P = 1000000007;
    private int lsum;
    private long nsum;

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        lsum = 0;
        for(int i = 1; i < A.length; i++) {
            int m = 1;
            nsum = 0;
            for(int j = 1; j <= i; j++) {
                nsum += m * (A[i] - A[i - j]);
                m *= 2;
                nsum %= P;
            }
            lsum = ((int) nsum + lsum) % P;
        }
        return lsum;
    }
}
