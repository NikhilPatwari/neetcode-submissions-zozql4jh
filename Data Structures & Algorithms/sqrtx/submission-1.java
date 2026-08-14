class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 0, r = x, m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (m * m == x) {
                return (int)m;
            } else if (m * m > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int)l - 1;
    }
}