class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> minHeapArrivalTime =
            new PriorityQueue<>((a, b) -> Integer.compare(a.arrivalTime, b.arrivalTime));
        PriorityQueue<Task> minHeapProcessTime = new PriorityQueue<>(
            (a, b)
                -> a.processTime != b.processTime ? Integer.compare(a.processTime, b.processTime)
                                                  : Integer.compare(a.index, b.index));
        for (int i = 0; i < tasks.length; i++) {
            Task t = new Task(i, tasks[i][0], tasks[i][1]);
            minHeapArrivalTime.offer(t);
        }
        int i = 0, t = 0;
        int[] res = new int[tasks.length];
        while (!(minHeapProcessTime.isEmpty() && minHeapArrivalTime.isEmpty())) {
            while (!minHeapArrivalTime.isEmpty() && t >= minHeapArrivalTime.peek().arrivalTime) {
                minHeapProcessTime.offer(minHeapArrivalTime.poll());
            }
            if (minHeapProcessTime.isEmpty()) {
                t = minHeapArrivalTime.peek().arrivalTime;
                while(!minHeapArrivalTime.isEmpty() && t >= minHeapArrivalTime.peek().arrivalTime)
                minHeapProcessTime.offer(minHeapArrivalTime.poll());
            }
            Task l = minHeapProcessTime.poll();
            t = Math.max(l.arrivalTime, t) + l.processTime;
            res[i] = l.index;
            i++;
        }
        return res;
    }
    private static class Task {
        int index;
        int arrivalTime;
        int processTime;
        Task(int index, int arrivalTime, int processTime) {
            this.index = index;
            this.arrivalTime = arrivalTime;
            this.processTime = processTime;
        }
    }
}