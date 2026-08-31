class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> aList = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i< prerequisites.length; i++){
            indegree[prerequisites[i][1]] ++;
            aList.computeIfAbsent(prerequisites[i][0], k-> new ArrayList<>()).add(prerequisites[i][1]);
        }
        for(int i = 0; i<numCourses; i++ ){
            if(indegree[i] == 0) q.offer(i);
        }
        int finish = 0;
        while(!q.isEmpty()){
            int i = q.poll();
            finish++;
            List<Integer> neighbour = aList.getOrDefault(i,new ArrayList<>());
            for(int j : neighbour){
                indegree[j] --;
                if(indegree[j] == 0){
                    q.offer(j);
                }
            }
        }
        return finish == numCourses;
    }
}
