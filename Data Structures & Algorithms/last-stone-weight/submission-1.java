class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            pq.offer(s);
        }
        while(!pq.isEmpty()){
            int stone1 = pq.poll();
            if(pq.isEmpty()){
                return stone1;
            }
            int stone2 = pq.poll();
            if(stone1 != stone2){
                pq.offer(Math.abs(stone1 - stone2));
            }
        }
        return 0;
    }
}
