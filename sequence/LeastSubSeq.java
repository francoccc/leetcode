package leetcode.sequence;

import java.util.LinkedList;

/**
 *
 * @author Franco
 * O(nlogn) solution
 * this problem quite confused
 */
public class LeastSubSeq {

    private int ans = Integer.MAX_VALUE;
    private LinkedList<Integer> queue = new LinkedList<>();
    private int[] distance;

    private int biSearch(LinkedList<Integer> queue, int i, int K) {
        int l = 0, r = queue.size() - 1, t = Integer.MAX_VALUE, m;
        while(l <= r) {
            m = (l + r) / 2;
            int ti = queue.get(m);
            if(distance[ti] >= distance[i] + K) {
                t = ti - i;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return t;
    }

    public int shortestSubarray(int[] A, int K) {
        distance = new int[A.length + 1];
        for(int i = 1; i <= A.length; i++) {
            distance[i] = distance[i - 1] + A[i - 1];
        }
        for(int i = A.length; i >= 0; i--) {
            while(!queue.isEmpty() && queue.peek() - i >= ans) queue.removeFirst();
            while(!queue.isEmpty() && distance[queue.peekLast()] <= distance[i]) queue.removeLast();
            queue.add(i);
            if(distance[queue.peek()] - distance[i] >= K) {
                int t = biSearch(queue, i, K);
                ans = ans > t ? t : ans;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
