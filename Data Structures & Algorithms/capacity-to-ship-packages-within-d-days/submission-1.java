class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1, r = 0, m, result = 1;
        for (int a : weights) {
            r += a;
            if (a > l) {
                l = a;
            }
        }
        while (l <= r) {
            m = l + (r - l) / 2;
            int time = getDays(weights, m);
            if (time <= days) {
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
    public int getDays(int[] weights, int weightLimit) {
        int days = 0, temp = weightLimit;

        for (int a : weights) {
            temp -= a;
            if (temp < 0) {
                days++;
                temp = weightLimit - a;
            }
        }
        if (temp >= 0) {
            days++;
        }
        return days;
    }
}