class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0, l = 1, m, ans = 0;
        for (int n : piles) {
            if (n > r) {
                r = n;
            }
        }
        while (l <= r) {
            m = l + (r - l) / 2;
            if (canEat(m, h, piles)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
    public boolean canEat(int m, int h, int[] piles) {
        int totalTime = 0;
        for (int x : piles) {
            totalTime += Math.ceil(x * 1.0 / m * 1.0);
        }
        return totalTime <= h;
    }
}
