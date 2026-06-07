class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, adj);
            }
        }
        return count;
    }
    private void dfs(int n, boolean[] visited, List<List<Integer>> adj) {
        if (visited[n]) {
            return;
        }
        visited[n] = true;
        for (int a : adj.get(n)) {
            dfs(a, visited, adj);
        }
    }
}