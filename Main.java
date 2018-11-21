package leetcode;

import leetcode.number.PrimeNumberSetBit;
import leetcode.sequence.SumSubSeqWidth;
import leetcode.string.PalindromeNum;

public class Main {

    public static void main(String[] args) {
        SumSubSeqWidth o = new SumSubSeqWidth();
        PrimeNumberSetBit p = new PrimeNumberSetBit();
        p.countPrimeSetBits(842, 888);
        System.out.println(o.sumSubseqWidths(new int[]{2, 1, 3}));
    }
}
