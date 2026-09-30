class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length==0){
            return true;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;

        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int finish =0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int n : adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0){
                    q.offer(n);
                }
            }
        }
        return numCourses == finish;
        
    }
}
