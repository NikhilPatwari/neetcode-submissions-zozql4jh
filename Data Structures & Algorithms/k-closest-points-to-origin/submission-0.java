class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        for (int i = 0; i < points.length;i++) {
            Pair p = new Pair(points[i][0], points[i][1]);
            q.offer(p);
            if(q.size() > k){
                q.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i< k; i++){
            Pair p = q.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;

    }
}
class Pair implements Comparable<Pair> {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair other) {
        return  ((other.x * other.x) + (other.y * other.y)) - ((x * x) + (y * y));
    }
}
