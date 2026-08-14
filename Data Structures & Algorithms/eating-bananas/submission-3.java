class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = (int) Math.ceil(piles.length *1.0 / h);
        int r = 0, m = 0, res = 0;
        for (int a : piles) {
            if (a > r) {
                r = a;
            }
        }

        while (l <= r) {
            m = l + (r - l) / 2;
            int hours = numHoursTaken(piles, m);
            if (hours <= h) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
    public int numHoursTaken(int[] piles, int k) {
        int hours = 0;
        for (int a : piles) {
            hours = (int) (hours + Math.ceil(a * 1.0 / k));
        }
        return hours;
    }
}
