package leetcode.number;

public class PrimeNumberSetBit {

    private boolean[] isPrime = new boolean[34];
    private int ans = 0;

    private int primeSetBit(int i) {
        int bits = 0;
        while(i != 0) {
            bits += i % 2;
            i /= 2;
        }
        if(!isPrime[bits]) return 1;
        return 0;
    }

    public int countPrimeSetBits(int L, int R) {
        isPrime[1] = !isPrime[1];
        for(int i = 2; i <= 32; i++) {
            if(!isPrime[i]) {
                for(int j = 2; j * i <= 32; j++)
                    if(!isPrime[j * i])
                        isPrime[j * i] = !isPrime[j * i];
            }
        }
        for(int i = L; i <= R; i++) {
            ans += primeSetBit(i);
        }
        return ans;
    }
}
