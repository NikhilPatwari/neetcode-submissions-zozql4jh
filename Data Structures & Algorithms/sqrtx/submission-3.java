class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0, r = 46340, m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (m * m == x) {
                return m;
            } else if (m * m > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l - 1;
    }
}