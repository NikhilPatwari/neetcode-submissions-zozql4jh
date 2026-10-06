class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> res = new HashMap<>();
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start time
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min heap of length, endTime
        int i = 0;
        for (int p : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= p) {
                q.offer(new int[] {intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            while (!q.isEmpty() && q.peek()[1] < p) {
                q.poll();
            }
            if (q.isEmpty()) {
                res.put(p, -1);
                continue;
            }
            res.put(p, q.peek()[0]);
        }
        for (int j = 0; j < queries.length; j++) {
            sortedQueries[j] = res.get(queries[j]);
        }
        return sortedQueries;
    }
}
