class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int c = pre[0];
            int p = pre[1];
            adj.get(p).add(c);
            indegree[c]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);

            }
        }
        int finish =0;
        while(!q.isEmpty()){
            int course = q.poll();
            finish++;
            for(int nei : adj.get(course)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }

        }
        return finish == numCourses;
    }
}
