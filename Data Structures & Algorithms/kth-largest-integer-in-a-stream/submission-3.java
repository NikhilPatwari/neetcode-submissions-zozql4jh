class KthLargest {
    int capacity;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.capacity = k;
        for(int n: nums){
            add(n);
        }

    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > capacity){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
