class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int n = nums.length;
        for (int num : nums) {
            q.offer(num);
            if (q.size() > n - k + 1) {
                q.poll();
            }
        }
        return q.poll();
    }
}
