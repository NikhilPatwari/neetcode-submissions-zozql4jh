class Solution {
    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        list.sort((a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return a.end - b.end;
        });
        List<Interval> result = new ArrayList<>();
        Interval a = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval b = list.get(i);
            if (a.end >= b.start) {
                a.start = Math.min(a.start, b.start);
                a.end = Math.max(a.end, b.end);
            } else {
                result.add(a);
                a = b;
            }
        }
        result.add(a);
        int[][] sol = new int[result.size()][2];
        for (int k = 0; k < result.size(); k++) {
            sol[k][0] = result.get(k).start;
            sol[k][1] = result.get(k).end;
        }
        return sol;
    }
    private static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
