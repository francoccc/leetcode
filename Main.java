package leetcode;

import leetcode.creator.RandomCreator;
import leetcode.sequence.SumSubSeqWidth;

public class Main {

    public static void main(String[] args) {
        SumSubSeqWidth o = new SumSubSeqWidth();
        RandomCreator creator = new RandomCreator(40, 5000);
        creator.out();
        System.out.println(o.sumSubseqWidths(new int[]{2, 1, 3}));
    }
}
