class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> aList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i< prerequisites.length; i++){
            aList.computeIfAbsent(prerequisites[i][0], k-> new ArrayList<>()).add(prerequisites[i][1]);
        }
        for(int i = 0; i<numCourses; i++){
            if(!dfs(i,aList,visited)) return false;
        }
        return true;
    }
    public boolean dfs(int course,Map<Integer, List<Integer>> aList, Set<Integer> visited ){
        if(!aList.containsKey(course) || aList.get(course).isEmpty()) return true;
        if(visited.contains(course)) return false;
        visited.add(course);
        List<Integer> neighbours = aList.get(course);
        for(int i = 0; i< neighbours.size(); i++){
            if(!dfs(neighbours.get(i),aList,visited)) return false;
        }
        aList.put(course, new ArrayList<>());
        return true;
    }
}
