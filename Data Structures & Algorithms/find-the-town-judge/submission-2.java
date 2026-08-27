class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            int j = indegree.getOrDefault(trust[i][1], 0);
            indegree.put(trust[i][1], j+1);
            int k = outdegree.getOrDefault(trust[i][0], 0);
            outdegree.put(trust[i][0], k+1);
        }
        for(int i = 1; i<= n; i++){
            if(indegree.getOrDefault(i, -1) == n-1 && outdegree.getOrDefault(i, 0) == 0 ) return i;
        }
        return -1;
    }
}