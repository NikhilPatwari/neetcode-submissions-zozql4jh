class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int [] indegree = new int[numCourses];
        for(int i = 0; i< numCourses; i++){
            for(int n : adj.get(i)){
                indegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int processed = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            processed++;
            for(int i : adj.get(n)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return processed == numCourses;
        
    }
}
