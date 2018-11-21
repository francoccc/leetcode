package leetcode.sequence;

import java.util.Arrays;

/**
 *
 * @author Franco
 * First sort the sequence, then if you get Ai and Aj(i < j)
 * The number of set which contains the min Ai and the max Aj
 * is 2^(j - i - 1).The problem is to solve the sum of (Aj -
 * Ai) * 2^(j - i - 1). Seperate and simplify the Aj and Ai
 * items,and you will get the final answer.
 * (i = 0 -> N - 1) (2^i - 2^N-i-1) * Ai
 */
public class SumSubSeqWidth2 {

    private final static int P = 1000000007;
    private long[] pow;

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        pow = new long[A.length];
        pow[0] = 1;
        int sum = 0;
        int N = A.length;
        for(int i = 1; i < N; i++) {
            pow[i] = pow[i - 1] * 2 % P;
        }

        for(int i = 0; i < N; i++) {
            sum += pow[i] * A[i] % P - pow[N - i - 1] * A[i] % P;
            sum %= P;
        }
        return sum;
    }
}
