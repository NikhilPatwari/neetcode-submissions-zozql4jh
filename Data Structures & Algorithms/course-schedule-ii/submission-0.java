class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int [numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++ ) adj.add(new ArrayList<>());

        for(int i = 0; i<prerequisites.length; i++ ){
            indegree[prerequisites[i][1]]++;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++ ){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int processed = 0;
        int [] order = new int[numCourses];
        while(!q.isEmpty()){
            int n = q.poll();
            order[numCourses - processed - 1 ] = n;
            processed++;
            for(int i : adj.get(n)){
                indegree[i] --;
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
        }
        if(processed == numCourses){
            return order;
        }
        return new int[0];
        
    }
}
