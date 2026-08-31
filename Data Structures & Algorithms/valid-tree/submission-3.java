class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> aList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i< n; i++){
            aList.add(new ArrayList<>());
        }
        for(int i = 0; i< edges.length; i++){
            aList.get(edges[i][0]).add(edges[i][1]);
            aList.get(edges[i][1]).add(edges[i][0]);
        }
        visited.add(0);
        if(hasCycle(aList,0,-1,visited)) return false;
        if(visited.size() == n) return true;
        return false;
    }
    public boolean hasCycle(List<List<Integer>> aList, int i,int parent, Set<Integer> visited){

        for(int j : aList.get(i)){
            if(j != parent && visited.contains(j)) return true;
            visited.add(j);
            if(j != parent && hasCycle(aList,j,i,visited)) return true;
        }

        return false;

    }
}
