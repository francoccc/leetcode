package leetcode.divide;

/**
 *
 * @author Franco
 * IntOverFlow
 */
public class FirstBadVesion {

    private int v;

    boolean isBadVersion(int version) {
        if(version >= v) return true;
        else return false;
    }

    private int _firstBadVersion(int l, int r) {
        int m;
        while(l < r) {
            if(isBadVersion(m = l + (r - l) / 2)) r = m;
            else l = m + 1;
        }
        return l;
    }

    public int firstBadVersion(int n , int v) {
        this.v = v;
        return _firstBadVersion(1, n);
    }
}
