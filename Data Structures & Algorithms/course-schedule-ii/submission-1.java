class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree= new int[numCourses];
        List<List<Integer>> aList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<numCourses;i++){
            aList.add(new ArrayList<>());
        }
        for(int i =0; i<prerequisites.length;i++){
            indegree[prerequisites[i][1]]++;
            aList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i =0; i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int i = q.poll();
            res.add(i);
            for(int j : aList.get(i)){
                indegree[j]--;
                if(indegree[j] == 0){
                    q.offer(j);
                }
            }
        }
        Collections.reverse(res);
        return res.size() == numCourses?res.stream().mapToInt(Integer::intValue)
                           .toArray(): new int[]{};

    }
}
