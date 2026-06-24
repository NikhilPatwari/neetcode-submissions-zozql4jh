class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : stones){
            q.offer(n);
        }
        while(q.size() > 1){
            int w1 = q.poll();
            // check if empty
            int w2 = q.poll();
            if(w1 > w2){
                q.offer(w1-w2);
            }
        }
        if(q.size() == 1){
            return q.poll();
        }
        return 0;
    }
}
