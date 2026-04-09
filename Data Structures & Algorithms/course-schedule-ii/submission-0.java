class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int prereq = pre[1];
            int course = pre[0];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int finish =0;
        int[] order = new int[numCourses];
        int index =0;
        while(!q.isEmpty()){
            int course = q.poll();
            order[index] = course;
            index++;
            finish++;
            for(int neighbour: adj.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        if(numCourses == finish){
            return order;
        }
        return new int[0];
    }
}
