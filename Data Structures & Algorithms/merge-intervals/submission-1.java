class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        List<int[]> result = new ArrayList<>();
        int[] a = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] b = intervals[i];
            if (a[1] >= b[0]) {
                a[0] = Math.min(a[0], b[0]);
                a[1] = Math.max(a[1], b[1]);
            } else {
                result.add(a);
                a = b;
            }
        }
        result.add(a);
        return result.toArray(new int[result.size()][]);
    }
}
