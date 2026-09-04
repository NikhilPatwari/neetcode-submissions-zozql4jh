class Solution {
    private List<Integer>[] adj;
    private int [][] dp;
    
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList[numCourses];
        dp = new int[numCourses+1][numCourses+1];
        for (int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
        } 
        for (int[] pre : prerequisites){
            adj[pre[1]].add(pre[0]);
            dp[pre[1]][pre[0]] = 1;
        } 

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(dfs(query[1], query[0]));
        }
        return res;
    }

    private boolean dfs(int node, int target) {
        if (node == target)
            return true;
        if(dp[node][target] != -1){
            return dp[node][target] == 1;
        }
        for (int nei : adj[node]) {
            if (dfs(nei, target)){
                dp[node][target] = 1;
                return true;
            }
        }
        dp[node][target] = 0;
        return false;
    }
}