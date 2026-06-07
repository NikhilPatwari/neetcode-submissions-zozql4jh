class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean iscycle = dfs(0, -1, visited, adj);
        if (iscycle) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int n, int parent, boolean[] visited, List<List<Integer>> adj) {
        if (visited[n]) {
            return true;
        }
        visited[n] = true;
        for (int a : adj.get(n)) {
            if (a != parent && dfs(a, n, visited, adj)) {
                return true;
            }
        }
        return false;
    }
}
